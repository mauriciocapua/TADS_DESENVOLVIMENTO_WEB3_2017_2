package server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.RecursoDAO;
import exceptions.RecursoNotFound;
import negocio.Recurso;

@WebService
public class VendasWS {
	private DataSource dataSource;

	private RecursoDAO recursoDAO;

	public VendasWS() throws NamingException {
		this.dataSource = (DataSource) new InitialContext().lookup("jdbc/trabalho2");
		recursoDAO = new RecursoDAO(dataSource);
	}

	@WebMethod
	@WebResult(name = "consultarecurso")
	public Recurso consultaRecurso(@WebParam(name = "id") String id, @WebParam(name = "quantidade") String quantidade)
			throws RecursoNotFound {
		Recurso recurso = new Recurso(Integer.parseInt(id), Integer.parseInt(quantidade));

		return recursoDAO.consulta(recurso);
	}

	@WebMethod
	@WebResult(name = "venderecurso")
	public boolean vendeRecurso(@WebParam(name = "idRecurso") String id, @WebParam(name = "venda") String venda,
			@WebParam(name = "version") String version) throws NumberFormatException, RecursoNotFound {
		return recursoDAO.vende(recursoDAO.getById(Integer.parseInt(id)), Integer.parseInt(venda), Integer.parseInt(version));
	}

}
