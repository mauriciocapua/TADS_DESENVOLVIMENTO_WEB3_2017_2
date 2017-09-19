package cobaia2server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import negocio.UserNotFoundException;

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
		if (p != null && !p.isEmpty())
			return (p);
		else
			throw new UserNotFoundException();
	}

}
