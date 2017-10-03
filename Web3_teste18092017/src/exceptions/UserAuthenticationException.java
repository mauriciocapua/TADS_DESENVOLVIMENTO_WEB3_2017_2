package exceptions;

public class UserAuthenticationException extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public UserAuthenticationException() {
		super("User authetication not found");
	}
}
