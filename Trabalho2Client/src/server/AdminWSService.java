
package server;

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
@WebServiceClient(name = "AdminWSService", targetNamespace = "http://server/", wsdlLocation = "http://erebus:8080/Trabalho2Server/AdminWSService?wsdl")
public class AdminWSService
    extends Service
{

    private final static URL ADMINWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADMINWSSERVICE_EXCEPTION;
    private final static QName ADMINWSSERVICE_QNAME = new QName("http://server/", "AdminWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://erebus:8080/Trabalho2Server/AdminWSService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADMINWSSERVICE_WSDL_LOCATION = url;
        ADMINWSSERVICE_EXCEPTION = e;
    }

    public AdminWSService() {
        super(__getWsdlLocation(), ADMINWSSERVICE_QNAME);
    }

    public AdminWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADMINWSSERVICE_QNAME, features);
    }

    public AdminWSService(URL wsdlLocation) {
        super(wsdlLocation, ADMINWSSERVICE_QNAME);
    }

    public AdminWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADMINWSSERVICE_QNAME, features);
    }

    public AdminWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdminWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdminWS
     */
    @WebEndpoint(name = "AdminWSPort")
    public AdminWS getAdminWSPort() {
        return super.getPort(new QName("http://server/", "AdminWSPort"), AdminWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdminWS
     */
    @WebEndpoint(name = "AdminWSPort")
    public AdminWS getAdminWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server/", "AdminWSPort"), AdminWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADMINWSSERVICE_EXCEPTION!= null) {
            throw ADMINWSSERVICE_EXCEPTION;
        }
        return ADMINWSSERVICE_WSDL_LOCATION;
    }

}
