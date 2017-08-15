import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class QueryXML
{	public static void main(String[] args)
	{	try
		{	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));
			XPath pat = XPathFactory.newInstance().newXPath();
			XPathExpression exp = pat.compile("/staff/employee[salary>2000]/firstname/text()");
			NodeList lst = (NodeList)exp.evaluate(doc,XPathConstants.NODESET);
			for (int i = 0; i < lst.getLength(); i++) System.out.println(lst.item(i).getNodeValue());
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}
}

