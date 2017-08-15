import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParseXML
{	public static void main(String[] args)
	{	try
		{	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));
			doc.getDocumentElement().normalize();
			System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
			NodeList lst = doc.getElementsByTagName("employee");
			for (int i = 0; i < lst.getLength(); i++)
			{	Node nod = lst.item(i);
				System.out.println("Current element: "+nod.getNodeName());
				//System.out.println("Current content: "+nod.getTextContent());
				if (nod.getNodeType() == Node.ELEMENT_NODE)
				{	Element ele = (Element)nod;
					System.out.println("Employee id: "+ele.getAttribute("id"));
					System.out.println("First name: "+ele.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last name: "+ele.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Salary: "+ele.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}
}

