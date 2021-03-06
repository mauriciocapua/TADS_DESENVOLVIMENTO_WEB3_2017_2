package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import negocio.DecoderJson;
import negocio.EncoderXML;

public class Main {

	public static void main(String[] args) throws IOException, ParseException{
		EncoderXML encoderXML = new EncoderXML();

//		String livroXML = encoderXML.leituraDosDados();
//		System.out.println(livroXML);
//		String livroMD5 = encoderXML.mD5ficador(livroXML);
//		System.out.println("MD5: " + livroMD5);
//
//		try (PrintWriter out = new PrintWriter("livro.xml")) {
//			out.println(livroXML);
//		}
//		try (PrintWriter out = new PrintWriter("md5.txt")) {
//			out.println(livroMD5);
//		}
		
		String md5 = "";
		List<String> texto = Files.readAllLines(Paths.get("textoJson.json"), StandardCharsets.UTF_8);
		DecoderJson decoderJson = new DecoderJson();
		System.out.println(md5.equals(decoderJson.mD5ficador(md5)));
		List<String> livro = decoderJson.readFile(texto);
		
		try (PrintWriter out = new PrintWriter("livro.txt")) {
			out.println(livro);
		}
		
		
		
		
	}
}
