package cobaia2server;

import javax.xml.ws.WebFault;

@WebFault
public class DatabaseErrorException extends Exception {
	private static final long serialVersionUID = 8022932796976615773L;

	public DatabaseErrorException() {
		super("Database error");
	}

}
