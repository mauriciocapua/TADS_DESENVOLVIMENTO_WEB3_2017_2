package exercicio1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Server {

	@WebMethod
	@WebResult(name = "token")
	public int login(@WebParam(name = "user", header = true) User user) throws UserAuthenticationException {
		if ((user != null) && (UserDAO.getByLogin(user.getLogin()) != null)) {
			if (TokenDAO.getTokensValidosNaoUsados(user.getLogin()) == 0) {
				return (1);
			}
		} else
			throw new UserAuthenticationException();
		return (0);
	}
}
