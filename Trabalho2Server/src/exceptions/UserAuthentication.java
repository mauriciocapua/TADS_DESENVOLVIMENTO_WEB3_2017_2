package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class UserAuthentication extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public UserAuthentication() {
		super("User authetication not found");
	}
}
