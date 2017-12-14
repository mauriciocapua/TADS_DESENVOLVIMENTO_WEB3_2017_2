package exceptions;
import javax.xml.ws.WebFault;

@WebFault
public class RecursoNotInsert extends Exception{
	private static final long serialVersionUID = 8022702696976615772L;

	public RecursoNotInsert() {
		super("Recurso not inserted");
	}
}
