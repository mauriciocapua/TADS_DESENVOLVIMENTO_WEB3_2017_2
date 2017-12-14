package server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/text")
public class Teste {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getString() {
		return ("Hello!");
	}

}
