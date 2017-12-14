package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public UserNotFoundException() {
		super("User not found");
	}

}