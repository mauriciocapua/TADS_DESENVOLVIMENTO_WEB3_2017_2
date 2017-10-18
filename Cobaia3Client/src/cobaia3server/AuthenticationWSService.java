
package cobaia3server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuthenticationWSService", targetNamespace = "http://cobaia3server/", wsdlLocation = "http://localhost:8080/Cobaia3Server/AuthenticationWSService?wsdl")
public class AuthenticationWSService
    extends Service
{

    private final static URL AUTHENTICATIONWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHENTICATIONWSSERVICE_EXCEPTION;
    private final static QName AUTHENTICATIONWSSERVICE_QNAME = new QName("http://cobaia3server/", "AuthenticationWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Cobaia3Server/AuthenticationWSService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHENTICATIONWSSERVICE_WSDL_LOCATION = url;
        AUTHENTICATIONWSSERVICE_EXCEPTION = e;
    }

    public AuthenticationWSService() {
        super(__getWsdlLocation(), AUTHENTICATIONWSSERVICE_QNAME);
    }

    public AuthenticationWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHENTICATIONWSSERVICE_QNAME, features);
    }

    public AuthenticationWSService(URL wsdlLocation) {
        super(wsdlLocation, AUTHENTICATIONWSSERVICE_QNAME);
    }

    public AuthenticationWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHENTICATIONWSSERVICE_QNAME, features);
    }

    public AuthenticationWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthenticationWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuthenticationWS
     */
    @WebEndpoint(name = "AuthenticationWSPort")
    public AuthenticationWS getAuthenticationWSPort() {
        return super.getPort(new QName("http://cobaia3server/", "AuthenticationWSPort"), AuthenticationWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthenticationWS
     */
    @WebEndpoint(name = "AuthenticationWSPort")
    public AuthenticationWS getAuthenticationWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://cobaia3server/", "AuthenticationWSPort"), AuthenticationWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHENTICATIONWSSERVICE_EXCEPTION!= null) {
            throw AUTHENTICATIONWSSERVICE_EXCEPTION;
        }
        return AUTHENTICATIONWSSERVICE_WSDL_LOCATION;
    }

}
