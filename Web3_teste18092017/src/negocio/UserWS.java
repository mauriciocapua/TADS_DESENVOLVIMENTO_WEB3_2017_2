package negocio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import dao.UserDAO;
import negocio.UserNotFoundException;
import negocio.Token;

@WebService
public class UserWS {

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
	@WebResult(name = "Token")
	public Token login(@WebParam(name = "login") String login, @WebParam(name = "senha") String senha)
			throws UserNotFoundException {
		// @xmlElement(required = true,
		// type = integer)
		// @xmlJavaAdapter(IntegerStringAdapter.class)
		Token token = null;
		User p = UserDAO.verifyUser(login, senha);
		if (p != null) {
			token = TokenDAO.getToken(p);
			return token;
		} else
			throw new UserNotFoundException();
	}

}
