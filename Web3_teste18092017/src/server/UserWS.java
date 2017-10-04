package server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import com.sun.jmx.snmp.Timestamp;

import dao.*;
import exceptions.*;
import negocio.*;
import javax.sql.DataSource;

@WebService
public class UserWS {

	// @Resource(mappedName = "jdbc/cobaia2")
	private DataSource dataSource;

	private TokenDAO tokenDAO;
	private DadoDAO dadoDAO;
	private UserDAO userDAO;

	public UserWS() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("jdbc/web3_teste18092017");
		userDAO = new UserDAO(dataSource);
		dadoDAO = new DadoDAO(dataSource);
		tokenDAO = new TokenDAO(dataSource);
	}

	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@WebMethod
	@WebResult(name = "User")
	public List<User> listAll() {
		return (userDAO.getAll());
	}

	@WebMethod
	@WebResult(name = "User")
	public User listById(@WebParam(name = "id")
	// @xmlElement(required = true,
	// type = integer)
	// @xmlJavaAdapter(IntegerStringAdapter.class)
	String id) throws UserNotFoundException {
		User p = userDAO.getById(Integer.parseInt(id));
		if (p != null)
			return (p);
		else
			throw new UserNotFoundException();
	}

	@WebMethod
	@WebResult(name = "verifyToken")
	public List<Token> login(@WebParam(name = "login") String login, @WebParam(name = "senha") String senha)
			throws Exception {
		List<Token> tokens = null;
		User user = userDAO.verifyUser(login, senha);
		if (user != null) {
			tokens = tokenDAO.getValidToken(user);
			if (tokens.size() > 0)
				return tokens;
			else {
				tokens = new ArrayList<Token>();
				tokens.add(createToken(user));
				return tokens;
			}
		} else
			throw new UserNotFoundException();
	}

	public Token createToken(User user) throws Exception {
		try {
			Date date = new Date();
			date.setMonth(date.getMonth() + 1);
			Token token = new Token(user.getLogin(), true, new Date(),
					// (Date) simpleDateFormat.parse("2017-09-24 15:00:00"),
					// (Date) simpleDateFormat.parse("2017-12-18 22:10:50")
					date);
			return tokenDAO.createToken(user, token);
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

	@WebMethod
	@WebResult(name = "dado")
	// public Dado consulta(@WebParam(name = "user", header = true) User user,
	// @WebParam(name = "token", header = true) Token token)
	// throws UserAuthenticationException, TokenValidNotFoundException {
	public Dado consulta() throws TokenValidNotFoundException, UserAuthenticationException {
		User user = new User(1, "mauricio", "123", null);
		List<Token> token = tokenDAO.getValidToken(user);
		System.out.println(token.size());

		if (user != null && userDAO.validateUser(user)) {
			if (tokenDAO.validateToken(token.get(0))) {
				Dado dado = dadoDAO.getDado(user, token.get(0));
				// TokenDAO.disableToken(token.get(0));
				return dado;
			} else
				throw new TokenValidNotFoundException();
		} else
			throw new UserAuthenticationException();
	}
	
	
	@WebMethod
	@WebResult(name = "dado")
	public User consultaVersion() throws TokenValidNotFoundException, UserAuthenticationException {
		User user = new User(1, "mauricio", "123", null);
		List<Token> token = tokenDAO.getValidToken(user);
		System.out.println(token.size());

		if (user != null && userDAO.validateUser(user)) {
			if (tokenDAO.validateToken(token.get(0))) {
				User userRetorno = userDAO.user(user);
				// TokenDAO.disableToken(token.get(0));
				return userRetorno;
			} else
				throw new TokenValidNotFoundException();
		} else
			throw new UserAuthenticationException();
	}

}