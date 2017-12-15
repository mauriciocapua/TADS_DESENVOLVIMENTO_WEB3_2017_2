package server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/adm")
public class Privado {
	// Parte protegida
	// - autenticão BASIC com JDBCRealm
	// - username-password fornecidos pelo usuário
	//

	@PUT
	@Path("vagas/{id_escola}/{serie}/{vagas}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putVagas(@PathParam(value = "") String matricula) {
		return matricula;
		// PUT
		// - cadastra vagas-série-escola
		// - insert se não existir, update se existir
		//
	}

	@PUT
	@Path("/periodo/{data_inicio}/{data_fim}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putVagas() {
		return null;
		// PUT
		// - cadastra vagas-série-escola
		// - insert se não existir, update se existir
		//
	}

	@GET
	@Path("/vagas")
	@Produces("application/json")
	public String getVagas() {
		return null;

		// - consulta situação rg-token
		// - matriculado escola-serie
		// - nao_matriculado

	}

	@GET
	@Path("/vagas/{id_escola}")
	@Produces("application/json")
	public String getVagasByIdEscola() {
		return null;

		// - consulta situação rg-token
		// - matriculado escola-serie
		// - nao_matriculado

	}

	@GET
	@Path("/vagas/{id_escola}/{serie}")
	@Produces("application/json")
	public String getVagasByIdEscolaSerie() {
		return null;

		// - consulta vagas-série-escola

	}

	@GET
	@Path("/periodo")
	@Produces("application/json")
	public String getPeriodo() {
		return null;
		// - consulta início-fim das matrículas

	}

	@GET
	@Path("/matriculas")
	@Produces("application/json")
	public String getMatriculas() {
		return null;
		// GET matriculas

	}

	@GET
	@Path("/matriculas")
	@Produces("application/json")
	public String getMatriculasBySerie() {
		return null;
		// GET matriculas/{serie}

	}

	@GET
	@Path("/matriculas/{bairro}")
	@Produces("application/json")
	public String getMatriculasByBairro() {
		return null;
		// GET matriculas/{bairro}
		// - consulta não matriculados

	}

}
