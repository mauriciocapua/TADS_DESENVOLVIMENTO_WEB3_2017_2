import java.io.File;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;

//xjc file.xsd -d . -p ""

public class JAXBUnmarshallingMarshallingXML
{	public static void main(String[] args)
	{	try
		{	JAXBContext ctx = JAXBContext.newInstance(Staff.class);

			Unmarshaller umar = ctx.createUnmarshaller();
			Staff stf = (Staff)umar.unmarshal(new File("file.xml"));

			stf.employee.get(0).setSalary(new BigDecimal(2500));

			Marshaller mar = ctx.createMarshaller();
			mar.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING,"UTF-8");
			mar.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			mar.marshal(stf,new File("newfile.xml"));
		}
		catch (Exception e)
		{	e.printStackTrace();
		}
	}
}

