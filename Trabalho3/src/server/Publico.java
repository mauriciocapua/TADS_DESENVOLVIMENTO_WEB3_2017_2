package server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/consulta")
public class Publico {

	@PUT
	@Path("matriculas/{nome}/{rg}/{nascimento}/{serie}/{cep}/{nro}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putMatricula(@PathParam(value = "") String matricula) {
		return matricula;
		/*
		 * - matricula criança nome-rg-nascimento-serie-cep-nro na serie-escola mais
		 * proxima com vaga disponível - retorna token para consultar situação - apenas
		 * de endereços de Rio Grande - apenas uma matrícula por rg - apenas durante o
		 * período de matrículas - endereco-bairro obtidos via webservice dos Correios -
		 * latitude-longitude obtidos via webservice do Google - distância casa-escola
		 * calculada pelo método distance() - se não conseguir matricular na 1a escola
		 * mais próxima, tenta na 2a, se não conseguir matricular na 2a escola mais
		 * próxima, tenta na 3a e assim por diante - pode não existir mais vaga na série
		 * desejada em nenhuma escola - concorrência
		 * 
		 * 
		 * double distance(double lat1, double lon1, double lat2, double lon2) {
		 * return(Math.acos(Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2)
		 * )*Math.cos(Math.toRadians(lon2-lon1))+Math.sin(Math.toRadians(lat1))*Math.sin
		 * (Math.toRadians(lat2)))*6378140); }
		 */
	}

	@GET
	@Path("matriculas/{rg}/{token}")
	@Produces("application/json")
	public String getMatriculas() {
		return null;

		// - consulta situação rg-token
		// - matriculado escola-serie
		// - nao_matriculado

	}

	@GET
	@Path("comprovante/{rg}/{token}")
	@Produces("application/json")
	public String getComprovante() {
		return null;

		// - solicita envio do comprovante de matrícula impresso via PAC Varejo pelo
		// Correio, da escola para casa da criança
		// - retorna custo-data_entrega
		// - custo-prazo_entrega obtidos via webservice dos Correios

	}

}
