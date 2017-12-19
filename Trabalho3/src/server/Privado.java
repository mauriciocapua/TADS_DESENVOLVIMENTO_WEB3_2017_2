package server;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.DadoDAO;
import dao.EscolaDAO;
import dao.MatriculaDAO;
import dao.PeriodoDAO;
import dao.TokenDAO;
import dao.UserDAO;
import dao.VagaDAO;
import negocio.Escola;
import negocio.Matricula;
import negocio.Periodo;
import negocio.Retorno;
import negocio.Vaga;

@Path("/privado")
public class Privado {

	private DataSource dataSource;

	private TokenDAO tokenDAO;
	private DadoDAO dadoDAO;
	private UserDAO userDAO;
	private MatriculaDAO matriculaDAO;
	private EscolaDAO escolaDAO;
	private VagaDAO vagaDAO;
	private PeriodoDAO periodoDAO;
	protected Gson gson = new GsonBuilder().create();

	public Privado() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("jdbc/trabalho3");
		userDAO = new UserDAO(dataSource);
		dadoDAO = new DadoDAO(dataSource);
		tokenDAO = new TokenDAO(dataSource);
		matriculaDAO = new MatriculaDAO(dataSource);
		escolaDAO = new EscolaDAO(dataSource);
		vagaDAO = new VagaDAO(dataSource);
		periodoDAO = new PeriodoDAO(dataSource);
	}

	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@PUT
	@Path("vagas/{id_escola}/{serie}/{vagas}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putVagas(@PathParam("id_escola") String idEscola, @PathParam("serie") String serie,
			@PathParam("vagas") String vagas) throws SQLException {
		boolean flag = false;
		Escola escola = new Escola(Integer.parseInt(idEscola));
		Retorno retorno = new Retorno();
		flag = vagaDAO.createVagas(escola, serie, vagas);
		if (flag) {
			retorno.setTexto("Periodo inserido");
			return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
		} else {
			retorno.setTexto("Periodo não inserido");
			return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
		}
		// PUT
		// - cadastra vagas-série-escola
		// - insert se não existir, update se existir
		//
	}

	@PUT
	@Path("/periodo/{inicio}/{fim}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putPeriodo(@PathParam("inicio") String inicio, @PathParam("fim") String fim, Periodo p)
			throws ClassNotFoundException, SQLException {

		Retorno retorno = new Retorno();
		Boolean flag = false;
		Periodo periodo = new Periodo();
		periodo.setInicio(parseDate(inicio));
		periodo.setFim(parseDate(fim));
		System.out.println(periodo.getInicio());
		flag = periodoDAO.createPeriodo(periodo);
		if (flag) {
			retorno.setTexto("Periodo inserido");
			return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
		} else {
			retorno.setTexto("Periodo não inserido");
			return Response.ok(gson.toJson(retorno), MediaType.APPLICATION_JSON).build();
		}
	}

	@GET
	@Path("/vagas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaga> getVagas() {
		List<Vaga> vagas = null;
		vagas = vagaDAO.findAll();
		return vagas;

	}

	@GET
	@Path("/vagas/{id_escola}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaga> getVagasByIdEscola(@PathParam("id_escola") String idEscola) {
		List<Vaga> vagas = null;
		Escola escola = new Escola(Integer.parseInt(idEscola));
		vagas = vagaDAO.findByEscola(escola);
		return vagas;

	}

	@GET
	@Path("/vagas/{id_escola}/{serie}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaga> getVagasByIdEscolaSerie(@PathParam("id_escola") String idEscola,
			@PathParam("serie") String serie) {
		List<Vaga> vagas = null;
		Escola escola = new Escola(Integer.parseInt(idEscola));
		vagas = vagaDAO.findByEscolaSerie(escola, Integer.parseInt(serie));
		return vagas;
	}

	@GET
	@Path("/periodo")
	@Produces(MediaType.APPLICATION_JSON)
	public Periodo getPeriodo() {
		Periodo periodo = null;
		periodo = periodoDAO.getPeriodo();
		return periodo;

	}

	@GET
	@Path("/matriculas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matricula> getMatriculas() {
		List<Matricula> matriculas = null;
		matriculas = matriculaDAO.findAll();
		return matriculas;
		// GET matriculas
	}

	@GET
	@Path("/matriculas/serie/{serie}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matricula> getMatriculasBySerie(@PathParam("serie") String serie) {
		List<Matricula> matriculas = null;
		matriculas = matriculaDAO.findStatusBySerie(serie);
		return matriculas;
		// GET matriculas/{serie}
	}

	@GET
	@Path("/matriculas/bairro/{bairro}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matricula> getMatriculasByBairro(@PathParam("bairro") String bairro) {
		List<Matricula> matriculas = null;
		matriculas = matriculaDAO.findStatusByBairro(bairro);
		return matriculas;
		// GET matriculas/{bairro}
		// - consulta não matriculados

	}

	public static Date parseDate(String d) {
		DateFormat simpleDateFormat = new SimpleDateFormat("EEEE MMM dd yy HH:mm:ss z");
		String stringDate = d;
		Date now = null;

		try {
			now = simpleDateFormat.parse(stringDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return now;
	}

}
