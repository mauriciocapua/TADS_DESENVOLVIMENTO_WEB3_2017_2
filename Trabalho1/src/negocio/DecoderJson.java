package negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecoderJson {
	public List<String> readFile(List<String> texto) throws FileNotFoundException, IOException {

		List<String> textOut = new ArrayList<>();
		Pattern pattern = Pattern.compile("\"(.+?)\"");
		Matcher matcher = pattern.matcher(texto.get(0));
//		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			System.out.println(matcher.group(1));
			textOut.add(matcher.group(1));
		}

		byte[] data = Base64.getDecoder().decode(textOut.get(textOut.size() - 1));
		try (OutputStream stream = new FileOutputStream("livro." + textOut.get(textOut.size() - 2))) {
			stream.write(data);
		}
		
		return textOut;
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

}
