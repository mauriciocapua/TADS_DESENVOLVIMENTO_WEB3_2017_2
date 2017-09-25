package negocio;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import com.sun.jmx.snmp.Timestamp;

import dao.TokenDAO;
import dao.UserDAO;
import exceptions.TokenValidNotFoundException;
import exceptions.UserNotFoundException;
import negocio.Token;

@WebService
public class UserWS {

	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@WebMethod
	@WebResult(name = "User")
	public List<User> listAll() {
		return (UserDAO.getAll());
	}

	@WebMethod
	@WebResult(name = "User")
	public User listById(@WebParam(name = "id")
	// @xmlElement(required = true,
	// type = integer)
	// @xmlJavaAdapter(IntegerStringAdapter.class)
	String id) throws UserNotFoundException {
		User p = UserDAO.getById(Integer.parseInt(id));
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
		User user = UserDAO.verifyUser(login, senha);
		if (user != null) {
			tokens = TokenDAO.getValidToken(user);
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
			return TokenDAO.createToken(user, token);
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

}
