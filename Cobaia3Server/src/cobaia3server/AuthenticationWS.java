package cobaia3server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AuthenticationWS {

	@WebMethod
	public boolean authenticate() {
		return (true);
	}

}