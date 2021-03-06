package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class EncoderXML {


	Scanner scanner = new Scanner(System.in);

	public String leituraDosDados() {
		String[] values = { "1", "1", "inglês", "Sex, Drugs and Rock'n'Roll", "2000-06-15", "Editora Abril", "1",
				"José da Silva", "png", "pokemon" };

		String livroXML = "";

		System.out.print("Digite o codigo do livro:");
		String codigo = escapar(scanner.nextLine());
		System.out.println("Digite o numero de traduções:");
		int numeroDeTitulos = Integer.parseInt(scanner.nextLine());
		String titulos = "";
		for (int j = 0; j < numeroDeTitulos; j++) {
			System.out.println("Digite a linguagem do titulo:");
			titulos = titulos + "<titulo linguagem=\"" + escapar(scanner.nextLine())+"\">";
			System.out.println("Digite o titulo :");
			titulos = titulos + escapar(scanner.nextLine()) + "</titulo>";
		}
		System.out.println("Digite o dia de publicacao:");
		String dia = escapar(scanner.nextLine());
		System.out.println("Digite o mes de publicacao:");
		String mes = escapar(scanner.nextLine());
		System.out.println("Digite o ano de publicacao:");
		String ano = escapar(scanner.nextLine());

		String publicacao = ano + "-" + mes + "-" + dia;

		System.out.println("Digite a editora:");
		String editora = escapar(scanner.nextLine());

		System.out.println("Digite o numero de autores:");
		int numeroDeAutores = Integer.parseInt(scanner.nextLine());

		String autores = "";

		for (int j = 0; j < numeroDeAutores; j++) {
			System.out.println("Digite o nome do autor Nº" + (j + 1) + ":");
			autores = autores + "<autor>" + escapar(scanner.nextLine()) + "</autor>";
		}

		System.out.println("Digite o nome do arquivo para capa:");
		String capa = scanner.nextLine();

		System.out.println("Digite o formato do arquivo:");
		String formato = escapar(scanner.nextLine());

		File file = new File(capa + "." + formato);
		String imagemBase64 = base64ficador(file);


		livroXML = "<?xml version='1.0' encoding='UTF-8'?>" + "<livro>" + "<codigo>" + codigo + "</codigo>" + "<titulos>"
				+ titulos + "</titulos>" + "<publicacao>" + publicacao + "</publicacao>" + "<editora>" + editora
				+ "</editora>" + "<autores>" + autores + "</autores>" + "<capa formato='png'>"
				+ imagemBase64 + "</capa>" + "</livro>";

		return livroXML;
	}

	public String base64ficador(File file) {
		String encodedBase64 = null;

		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.getEncoder().encode(bytes));
			fileInputStreamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return encodedBase64;
	}

	public String mD5ficador(String string) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(string));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("%032x", new BigInteger(1, md5.digest()));

	}

	public String escapar(String palavra) {
		System.out.println(palavra);
		palavra = palavra.replaceAll("[aáâàã]", "a")
		.replaceAll("[eéêè]", "e")
		.replaceAll("[iíîì]", "i")
		.replaceAll("[oóôòõ]", "o")
		.replaceAll("[uúûù]", "u")
		.replaceAll("[cç]", "c")
		.replaceAll("<", "&lt;")
		.replaceAll("&", "&amp;")
		.replaceAll(">", "&gt;")
		.replaceAll("\"", "&quot;")
		.replaceAll("\'","&apos;");
//		palavra = Pattern.compile("([^a-zA-z0-9\\ \\,])");
//		palavra = escaper.matcher(palavra).replaceAll("\\\\$1");
		System.out.println(palavra);
		return palavra;
	}
	

}
