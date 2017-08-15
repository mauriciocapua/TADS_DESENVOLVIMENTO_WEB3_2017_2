import java.io.File;
import org.w3c.dom.Document;
import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Validator;

class ValidateXML
{	public static void main(String[] args)
	{	try
		{	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));
			Schema sch = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("file.xsd"));
			Validator val = sch.newValidator();
			val.validate(new DOMSource(doc));
			System.out.println("OK");
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}
}

