package main;

import java.io.IOException;
import java.text.ParseException;

import negocio.DecoderJson;
import negocio.EncoderXML;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
		EncoderXML encoderXML = new EncoderXML();

//		String livroXML = encoderXML.leituraDosDados();
//		System.out.println(livroXML);
//		String livroMD5 = encoderXML.mD5ficador(livroXML);
//		System.out.println("MD5: " + livroMD5);

//		try (PrintWriter out = new PrintWriter("livro.xml")) {
//			out.println(livroXML);
//		}
//		try (PrintWriter out = new PrintWriter("md5.txt")) {
//			out.println(livroMD5);
//		}

//		List<String> textoJson = Files.readAllLines(Paths.get("textoJson.json"),
//				 StandardCharsets.UTF_8);
		 DecoderJson decoderJson = new DecoderJson();
		 decoderJson.readFile();
	}

}
