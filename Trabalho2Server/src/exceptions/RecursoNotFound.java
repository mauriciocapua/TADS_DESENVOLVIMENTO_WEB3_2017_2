package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RecursoNotFound extends Exception{
	private static final long serialVersionUID = 8022702696976615772L;

	public RecursoNotFound() {
		super("Recurso not found");
	}
}
