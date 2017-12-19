import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.gson.Gson;

import exceptions.UserAuthenticationException;
import negocio.CResultado;
import negocio.Escola;
import negocio.Matricula;
import negocio.Periodo;
import negocio.Retorno;
import negocio.Vaga;

public class Main {

	public static void main(String[] args) throws UserAuthenticationException {

		ClientConfig clientConfig = new ClientConfig();

		HttpAuthenticationFeature featurePublic = HttpAuthenticationFeature.basic("user", "12345");
		HttpAuthenticationFeature featurePrivate = HttpAuthenticationFeature.basic("admin", "12345");

		clientConfig.register(featurePublic);
		clientConfig.register(JacksonFeature.class);

		Client clientPublico = ClientBuilder.newClient(clientConfig);

		ClientConfig clientConfig2 = new ClientConfig();
		clientConfig2.register(featurePrivate);
		clientConfig2.register(JacksonFeature.class);

		Client clientPrivado = ClientBuilder.newClient(clientConfig2);

		// getMatriculasRg(clientPublico);
		// getComprovante(clientPublico);

		// getVagas(clientPrivado);
		// getVagasByIdEscola(clientPrivado);
		// getVagasByIdEscolaSerie(clientPrivado);
		// getPeriodo(clientPrivado);
		// getMatriculas(clientPrivado);

		// getMatriculasSerie(clientPrivado);
		// getMatriculasBairro(clientPrivado);
		// insertVagas(clientPrivado);
		// insertPeriodo(clientPrivado);

	}

	public static void getMatriculasRg(Client client) throws UserAuthenticationException {
		Matricula matricula = new Matricula("mauricio", "6080787358", parseDate("1992-03-06 09:46:06.732"), "1",
				"96201090", "355");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rg", matricula.getRg());
		map.put("token", 1);

		try {
			Response response = client.target("http://localhost:8080/Trabalho3/rest/publico/matriculas/{rg}/{token}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON).get();
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				Retorno retorno = response.readEntity(Retorno.class);
				System.out.println(retorno.getTexto());
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getComprovante(Client client) throws UserAuthenticationException {
		Matricula matricula = new Matricula("mauricio", "6080787358", parseDate("1992-03-06 09:46:06.732"), "1",
				"96201090", "355");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rg", matricula.getRg());
		map.put("token", 1);

		try {
			Response response = client.target("http://localhost:8080/Trabalho3/rest/publico/comprovante/{rg}/{token}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON).get();
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				Retorno retorno = response.readEntity(Retorno.class);
				Gson gson = new Gson();
				CResultado cResultado = gson.fromJson(retorno.getTexto(), CResultado.class);
				System.out.println(
						"Valor: " + cResultado.getServicos().getCServico().get(0).getValor() + " \nPrazo de entrega "
								+ cResultado.getServicos().getCServico().get(0).getPrazoEntrega() + " dias");
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getVagas(Client client) throws UserAuthenticationException {
		try {
			List<Vaga> vagas = client.target("http://localhost:8080/Trabalho3/rest/privado/vagas").request()
					.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Vaga>>() {
					});

			if (vagas.size() != 0 && vagas != null) {
				for (Vaga vaga : vagas) {
					System.out.println(vaga.toString());
				}
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getVagasByIdEscola(Client client) throws UserAuthenticationException {
		Escola escola = new Escola(1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_escola", escola.getId());

		try {
			List<Vaga> vagas = client.target("http://localhost:8080/Trabalho3/rest/privado/vagas/{id_escola}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Vaga>>() {
					});

			if (vagas.size() != 0 && vagas != null) {
				for (Vaga vaga : vagas) {
					System.out.println(vaga.toString());
				}
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getVagasByIdEscolaSerie(Client client) throws UserAuthenticationException {
		Escola escola = new Escola(1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_escola", escola.getId());
		map.put("serie", 1);

		try {
			List<Vaga> vagas = client.target("http://localhost:8080/Trabalho3/rest/privado/vagas/{id_escola}/{serie}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Vaga>>() {
					});

			if (vagas.size() != 0 && vagas != null) {
				for (Vaga vaga : vagas) {
					System.out.println(vaga.toString());
				}
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getPeriodo(Client client) throws UserAuthenticationException {
		try {
			Periodo periodo = client.target("http://localhost:8080/Trabalho3/rest/privado/periodo").request()
					.accept(MediaType.APPLICATION_JSON).get(Periodo.class);

			if (periodo != null) {
				System.out.println(periodo.toString());
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getMatriculas(Client client) throws UserAuthenticationException {
		try {
			List<Matricula> matriculas = client.target("http://localhost:8080/Trabalho3/rest/privado/matriculas")
					.request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Matricula>>() {
					});

			if (matriculas.size() != 0 && matriculas != null) {
				for (Matricula matricula : matriculas) {
					System.out.println(matricula.toString());
				}
			} else {
				System.out.println("Nenhuma matrícula encontrada");
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getMatriculasSerie(Client client) throws UserAuthenticationException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serie", 1);

		try {
			List<Matricula> matriculas = client
					.target("http://localhost:8080/Trabalho3/rest/privado/matriculas/serie/{serie}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Matricula>>() {
					});

			if (matriculas.size() != 0 && matriculas != null) {
				for (Matricula matricula : matriculas) {
					System.out.println(matricula.toString());
				}
			} else {
				System.out.println("Nenhuma matrícula encontrada");
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void getMatriculasBairro(Client client) throws UserAuthenticationException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bairro", "Getulio Vargas");

		try {
			List<Matricula> matriculas = client
					.target("http://localhost:8080/Trabalho3/rest/privado/matriculas/bairro/{bairro}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Matricula>>() {
					});

			if (matriculas.size() != 0 && matriculas != null) {
				for (Matricula matricula : matriculas) {
					System.out.println(matricula.toString());
				}
			} else {
				System.out.println("Nenhuma matrícula encontrada");
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}
	}

	public static void insertVagas(Client client) throws UserAuthenticationException {

		Vaga vagas = new Vaga();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_escola", 1);
		map.put("serie", 1);
		map.put("vagas", 30);
		try {
			Response response = client
					.target("http://localhost:8080/Trabalho3/rest/privado/vagas/{id_escola}/{serie}/{vagas}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON).put(Entity.json(vagas));
			if (response.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
				throw new RuntimeException("Failed to update");
			} else {
				Retorno retorno = response.readEntity(Retorno.class);
				System.out.println(retorno.getTexto());
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}

	}

	public static void insertPeriodo(Client client) throws UserAuthenticationException {

		Periodo periodo = new Periodo();
		periodo.setInicio(parseDate("2017-02-06"));
		periodo.setFim(parseDate("2017-03-06"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inicio", periodo.getInicio());
		map.put("fim", periodo.getFim());
		try {
			Response response = client.target("http://localhost:8080/Trabalho3/rest/privado/periodo/{inicio}/{fim}")
					.resolveTemplates(map).request().accept(MediaType.APPLICATION_JSON).put(Entity.json(periodo));
			if (response.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
				throw new RuntimeException("Failed to update");
			} else {
				Retorno retorno = response.readEntity(Retorno.class);
				System.out.println(retorno.getTexto());
			}
		} catch (ForbiddenException e) {
			throw new UserAuthenticationException();
		}

	}

	public static void insertMatricula(Client clientPublico) {

		Matricula matricula = new Matricula("tati", "1231231341", parseDate("1992-03-06 09:46:06.732"), "1", "96201090",
				"355");

		// Form form = new Form().param("nome", "tati").param("last", "Burke");
		// UriBuilder builder =
		// UriBuilder.fromPath("matriculas/{nome}/{rg}/{nascimento}/{serie}/{cep}/{nro}")
		// .scheme("http").host("{hostname}");
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("hostname", "localhost:8080/Trabalho3/rest/publico");
		map.put("nome", matricula.getNome());
		map.put("rg", matricula.getRg());
		map.put("nascimento", matricula.getNascimento());
		map.put("serie", matricula.getSerie());
		map.put("cep", matricula.getCep());
		map.put("nro", matricula.getNro());
		// UriBuilder clone = builder.clone();
		// URI uri = clone.buildFromMap(map);
		//
		// Response response = client.target(uri).request().put(Entity.json(matricula));
		// response.close();

		Response response = clientPublico.target(
				"http://localhost:8080/Trabalho3/rest/publico/matriculas/{nome}/{rg}/{nascimento}/{serie}/{cep}/{nro}")
				.resolveTemplates(map).request().put(Entity.json(matricula));

		// Response response = client.target(
		// "http://localhost:8080/Trabalho3/rest/publico/inserematriculas/{nome}/{rg}/{nascimento}/{serie}/{cep}/{nro}")
		// .resolveTemplates("nome", matricula.getNome(), "rg", matricula.getRg(),
		// "nascimento", now, "serie",
		// matricula.getSerie(), "cep", matricula.getCep(), "nro", matricula.getNro())
		// .request().put(Entity.json(matricula));
		// response.close();
		if (response.getStatus() == Response.Status.OK.getStatusCode())
			System.out.println(response.toString());
		else
			throw new RuntimeException("Failed to update");
	}

	public static Date parseDate(String d) {
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
