package server;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.RecursoDAO;
import dao.UserDAO;
import exceptions.RecursoNotFound;
import exceptions.RecursoNotInsert;
import exceptions.UserNotFound;
import negocio.Recurso;
import negocio.User;

@WebService
public class AdminWS {
	private DataSource dataSource;

	private RecursoDAO recursoDAO;
	private UserDAO userDAO;

	public AdminWS() throws NamingException {
		this.dataSource = (DataSource) new InitialContext().lookup("jdbc/trabalho2");
		recursoDAO = new RecursoDAO(dataSource);
		userDAO = new UserDAO(dataSource);
	}

	@WebMethod
	@WebResult(name = "incluirecurso")
	public Recurso incluiRecurso(@WebParam(name = "id") String id, @WebParam(name = "descricao") String descricao,
			@WebParam(name = "quantidade") String quantidade) throws RecursoNotInsert {
		Recurso recurso = new Recurso(Integer.parseInt(id), descricao, Integer.parseInt(quantidade));

		recurso = recursoDAO.insert(recurso);

		return recurso;
	}

	@WebMethod
	@WebResult(name = "comprarecurso")
	public boolean compraRecurso(@WebParam(name = "id") String id, @WebParam(name = "quantidade") String quantidade) throws  RecursoNotFound
			 {
		Recurso recurso = new Recurso(Integer.parseInt(id), Integer.parseInt(quantidade));

		return recursoDAO.compra(recurso);
	}

	@WebMethod
	@WebResult(name = "User")
	public List<User> listAll() {
		return (userDAO.getAll());
	}

	@WebMethod
	@WebResult(name = "User")
	public User listById(@WebParam(name = "id") String id) throws UserNotFound {
		User p = userDAO.getById(Integer.parseInt(id));
		if (p != null)
			return (p);
		else
			throw new UserNotFound();
	}
}
