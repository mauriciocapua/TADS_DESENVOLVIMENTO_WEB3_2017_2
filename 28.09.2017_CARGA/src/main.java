import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;

public class main {
	public static void main(String[] args) {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("D:\\Meus Documentos\\Ifrs\\TADS_WORKSPACE\\TADS_HOMEWORK\\TADS_DESENVOLVIMENTO_WEB3_2017_2\\28.09.2017_CARGA\\src\\exercicio.xml"));
			Schema sch = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("D:\\Meus Documentos\\Ifrs\\TADS_WORKSPACE\\TADS_HOMEWORK\\TADS_DESENVOLVIMENTO_WEB3_2017_2\\28.09.2017_CARGA\\src\\carga.xsd"));
			Validator val = sch.newValidator();
			val.validate(new DOMSource(doc));
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
