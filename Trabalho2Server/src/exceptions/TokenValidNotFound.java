package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class TokenValidNotFound extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public TokenValidNotFound() {
		super("Token valid not found");
	}
}
