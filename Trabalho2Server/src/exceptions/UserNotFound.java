package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class UserNotFound extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public UserNotFound() {
		super("User not found");
	}

}