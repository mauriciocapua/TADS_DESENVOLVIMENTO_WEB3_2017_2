package server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.TokenDAO;
import dao.UserDAO;
import exceptions.UserNotFound;
import negocio.Token;
import negocio.User;

@WebService
public class UserWS {

	private DataSource dataSource;

	private TokenDAO tokenDAO;
	private UserDAO userDAO;

	public UserWS() throws NamingException {
		this.dataSource = (DataSource) new InitialContext().lookup("jdbc/trabalho2");
		userDAO = new UserDAO(dataSource);
		tokenDAO = new TokenDAO(dataSource);
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
			throw new UserNotFound();
	}

	public Token createToken(User user) throws Exception {
		try {
			Date date = new Date();
			date.setMonth(date.getMonth() + 1);
			Token token = new Token(user.getUserid(), true, new Date(), date);
			return tokenDAO.createToken(user, token);
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

}