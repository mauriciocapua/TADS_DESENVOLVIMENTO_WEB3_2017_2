import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class TransverseXML
{	public static void main(String[] args)
	{	try
		{	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));
			System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) printNode(doc.getChildNodes());
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}

	private static void printNode(NodeList lst)
	{	for (int i = 0; i < lst.getLength(); i++)
		{	Node nod1 = lst.item(i);
			if (nod1.getNodeType() == Node.ELEMENT_NODE)
			{	System.out.println("Node name: "+nod1.getNodeName()+" [OPEN]");
				System.out.println("Node value: "+nod1.getTextContent());
				if (nod1.hasAttributes())
				{	NamedNodeMap map = nod1.getAttributes();
					for (int j = 0; j < map.getLength(); j++)
					{	Node nod2 = map.item(j);
						System.out.println("Attr name: "+nod2.getNodeName());
						System.out.println("Attr value: "+nod2.getNodeValue());
					}
				}
				if (nod1.hasChildNodes()) printNode(nod1.getChildNodes());
				System.out.println("Node name: "+nod1.getNodeName()+" [CLOSE]");
			}
		}
	}
}

