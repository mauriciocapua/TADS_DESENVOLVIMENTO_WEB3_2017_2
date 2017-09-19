	package cobaia2server;

import javax.xml.ws.WebFault;

@WebFault
public class PersonNotFoundException extends Exception {
	private static final long serialVersionUID = 8022702696976615772L;

	public PersonNotFoundException() {
		super("Person not found");
	}

}