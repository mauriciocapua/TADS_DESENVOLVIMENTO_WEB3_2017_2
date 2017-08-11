package negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.simple.parser.ParseException;

public class DecoderJson {
	public void readFile() throws FileNotFoundException, IOException, ParseException {


		// for (Object o : jsonArray) {
		// JSONObject person = (JSONObject) o;
		//
		// String strName = (String) person.get("name");
		// System.out.println("Name::::" + strName);
		//
		// String strCity = (String) person.get("city");
		// System.out.println("City::::" + strCity);
		//
		// JSONArray arrays = (JSONArray) person.get("cars");
		// for (Object object : arrays) {
		// System.out.println("cars::::" + object);
		// }
		// String strJob = (String) person.get("job");
		// System.out.println("Job::::" + strJob);
		// System.out.println();
		//
		// }

		List<String> textoJson = Files.readAllLines(Paths.get("textoJson.json"), StandardCharsets.UTF_8);

		String s = "";
		for (String item : textoJson) {
			s = s + item;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
//			System.out.println(s);
			Livro livro = mapper.readValue(s, Livro.class);
			
			byte[] data = Base64.getDecoder().decode(livro.getCapa().getValor());
			try (OutputStream stream = new FileOutputStream(livro.getTitulo().get(0)+"."+livro.getCapa().getFormato())) {
			    stream.write(data);
			}

			mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			s = mapper.writeValueAsString(livro);
			
			
			
			System.out.println(s);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// livro = { codigo:1, titulo:[ { linguagem:"english", valor:"Sex, Drugs and
// Rock'n'Roll" }, { linguagem:"portugues", valor:"Sexo, Drogas e Rock'n'Roll" }
// ], publicacao:"2000-06-15", editora:"Editora Abril", autores:[ "Jos� da
// Silva", "Maria Brasil" ], capa:{ formato:"png", valor:"..." } }
//
// JavaScript Object Notation (JSON)
// https://www.w3schools.com/js/js_json_intro.asp
// pares atributo:valor separados por ,
// {} = object
// [] = array
// * utiliza menos bytes que XML
