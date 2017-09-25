package exceptions;

public class TokenValidNotFoundException extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public TokenValidNotFoundException() {
		super("Token valid not found");
	}
}
