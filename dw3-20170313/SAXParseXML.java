import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParseXML
{	public static void main(String argv[])
	{	try
		{	DefaultHandler handler = new DefaultHandler()
			{	boolean fname = false;
				boolean lname = false;
				boolean salary = false;

				public void startElement(String uri, String lName, String qName, Attributes attributes) throws SAXException
				{	System.out.println("Start element: "+qName);
					if (qName.equalsIgnoreCase("employee")) System.out.println("Employee id: "+attributes.getValue(0));
					fname = qName.equalsIgnoreCase("firstname");
					lname = qName.equalsIgnoreCase("lastname");
					salary = qName.equalsIgnoreCase("salary");
				}

				public void endElement(String uri, String lName, String qName) throws SAXException
				{	System.out.println("End element: "+qName);
				}

				public void characters(char ch[], int start, int length) throws SAXException
				{	if (fname)
					{	System.out.println("First name: "+new String(ch,start,length));
						fname = false;
					}
					if (lname)
					{	System.out.println("Last name: "+new String(ch,start,length));
						lname = false;
					}
					if (salary)
					{	System.out.println("Salary: "+new String(ch,start,length));
						salary = false;
					}
				}
			};

			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			saxParser.parse(new File("file.xml"),handler);
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}
}

