package exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RecursoSemEstoque extends Exception{
	private static final long serialVersionUID = 8022702696976615772L;

	public RecursoSemEstoque() {
		super("Recurso sem estoque");
	}
}
