package server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DadoDAO;
import dao.TokenDAO;
import dao.UserDAO;
import negocio.User;

@Path("/myresource")
public class MyResource {

	private DataSource dataSource;

	private TokenDAO tokenDAO;
	private DadoDAO dadoDAO;
	private UserDAO userDAO;

	public MyResource() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("jdbc/web3_teste18092017");
		userDAO = new UserDAO(dataSource);
		dadoDAO = new DadoDAO(dataSource);
		tokenDAO = new TokenDAO(dataSource);
	}

	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@GET
	@Path("/text/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getText(@PathParam("name") String name) {
		return ("( name=" + name + " )");
	}

	@GET
	@Path("/xml/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public String getXML(@PathParam("name") String name) {
		return ("<name>" + name + "</name>");
	}

	@GET
	@Path("/json/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getJSON(@PathParam("name") String name) {
		return ("{ \"name\": \"" + name + "\" }");
	}

	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getCustomer(@PathParam("id") int id) {
		User user = userDAO.getById(id);

		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		System.out.println(user.getLogin());
		return (user);
	}

}
