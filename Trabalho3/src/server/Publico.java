package server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.axis.utils.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import correios.CResultado;
import correios.CalcPrecoDataResponse;
import correios.CalcPrecoPrazoData;
import correios.CalcPrecoPrazoWS;
import dao.DadoDAO;
import dao.EscolaDAO;
import dao.MatriculaDAO;
import dao.TokenDAO;
import dao.UserDAO;
import exceptions.TokenValidNotFoundException;
import negocio.Escola;
import negocio.Matricula;
import negocio.Retorno;
import negocio.Token;

@Path("/publico")
public class Publico {

	private DataSource dataSource;

	private TokenDAO tokenDAO;
	private DadoDAO dadoDAO;
	private UserDAO userDAO;
	private MatriculaDAO matriculaDAO;
	private EscolaDAO escolaDAO;
	protected Gson gson = new GsonBuilder().create();

	public Publico() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("jdbc/trabalho3");
		userDAO = new UserDAO(dataSource);
		dadoDAO = new DadoDAO(dataSource);
		tokenDAO = new TokenDAO(dataSource);
		matriculaDAO = new MatriculaDAO(dataSource);
		escolaDAO = new EscolaDAO(dataSource);
	}

	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@PUT
	@Path("/matriculas/{nome}/{rg}/{nascimento}/{serie}/{cep}/{nro}")
	// @Path("/inserematriculas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String putMatricula(@PathParam("rg") String rg, @PathParam("nome") String nome,
			@PathParam("nascimento") String nascimento, @PathParam("serie") String serie, @PathParam("cep") String cep,
			@PathParam("nro") String nro) throws IOException {
		System.out.println(rg);

		// URL url = new
		// URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=-32.1078535,-52.1806025"
		// + "&key="
		// + "AIzaSyD61ATXK076HM4kGktkVuyrdxNAr2AfdwU");
		// HttpURLConnection con = (HttpURLConnection) url.openConnection();
		// if (con.getResponseCode() != 200) {
		// return null;
		// }
		//
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(con.getInputStream()));
		// String inputLine;
		// StringBuffer response = new StringBuffer();
		//
		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }
		// in.close();
		Client client = ClientBuilder.newClient();
		Builder response = client.target(
				"https://maps.googleapis.com/maps/api/geocode/json?latlng=-32.1078535,-52.1806025&key=AIzaSyD61ATXK076HM4kGktkVuyrdxNAr2AfdwU")
				.request().accept(MediaType.APPLICATION_JSON);

		System.out.println(response.toString());
		// return response.toString();
		return Response.status(500).toString();
		/*
		 * // * - matricula criança nome-rg-nascimento-serie-cep-nro na serie-escola
		 * mais // * proxima com vaga disponível - retorna token para consultar situação
		 * - // apenas // * de endereços de Rio Grande - apenas uma matrícula por rg -
		 * apenas durante o // * período de matrículas - endereco-bairro obtidos via
		 * webservice dos Correios // - // * latitude-longitude obtidos via webservice
		 * do Google - distância casa-escola // * calculada pelo método distance() - se
		 * não conseguir matricular na 1a escola // * mais próxima, tenta na 2a, se não
		 * conseguir matricular na 2a escola mais // * próxima, tenta na 3a e assim por
		 * diante - pode não existir mais vaga na // série // * desejada em nenhuma
		 * escola - concorrência // * // * // * double distance(double lat1, double
		 * lon1, double lat2, double lon2) { // * //
		 * return(Math.acos(Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2)
		 * // * //
		 * )*Math.cos(Math.toRadians(lon2-lon1))+Math.sin(Math.toRadians(lat1))*Math.sin
		 * // * (Math.toRadians(lat2)))*6378140); } //
		 */
	}

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String teste() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(
				"https://maps.googleapis.com/maps/api/geocode/json?address=340+Oswaldo+Martensen,+Rio+Grande+Do+Sul,+RS&key=AIzaSyD61ATXK076HM4kGktkVuyrdxNAr2AfdwU")
				.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.toString());
		return gson.toJson(gson.toJson(response.toString()));
	}

	@GET
	@Path("/matriculas/{rg}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatriculasRg(@PathParam("rg") String rg, @PathParam("token") String tokenId) throws Exception {
		Token token = new Token();
		token.setId(Integer.parseInt(tokenId));
		Retorno retorno = new Retorno();

		if (tokenDAO.validateToken(token)) {
			Matricula matricula = null;
			Escola escola = null;
			matricula = matriculaDAO.findStatusByRg(rg);
			escola = escolaDAO.findEscola(matricula);
			if (matricula != null && escola != null) {
				retorno.setTexto("matricula na escola " + escola.getNome() + " na serie " + matricula.getSerie());
				return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
			} else {
				retorno.setTexto("não matriculado");
				return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
			}
		}
		retorno.setTexto("token inválido");
		return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/comprovante/{rg}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComprovante(@PathParam("rg") String rg, @PathParam("token") String tokenId) {
		Token token = new Token();
		token.setId(Integer.parseInt(tokenId));
		Retorno retorno = new Retorno();

		if (tokenDAO.validateToken(token)) {
			Matricula matricula = null;
			Escola escola = null;
			matricula = matriculaDAO.findStatusByRg(rg);
			escola = escolaDAO.findEscola(matricula);
			if (matricula != null && escola != null) {

				CalcPrecoPrazoWS calcPrecoPrazoWS = new CalcPrecoPrazoWS();
				CResultado cResultado = new CResultado();
				cResultado = calcPrecoPrazoWS.getCalcPrecoPrazoWSSoap().calcPrecoPrazoData("", "", "41106",
						escola.getCep(), matricula.getCep(), "1", 1, BigDecimal.valueOf(16), BigDecimal.valueOf(2),
						BigDecimal.valueOf(11), BigDecimal.valueOf(16), "", BigDecimal.valueOf(18), "", "");
				// return gson.toJson(cResultado);
				retorno.setTexto(gson.toJson(cResultado).toString());
				return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
			} else {
				retorno.setTexto("não matriculado");
				return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
			}
		}
		retorno.setTexto("token inválido");
		return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();

	}

}
