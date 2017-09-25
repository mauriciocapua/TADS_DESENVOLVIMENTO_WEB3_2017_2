package exercicio1;

import javax.xml.ws.WebFault;

@WebFault
public class UserAuthenticationException extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public UserAuthenticationException() {
		super("User not found");
	}

}
