
package server;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UserNotFoundException", targetNamespace = "http://server/")
public class UserNotFoundException_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UserNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UserNotFoundException_Exception(String message, UserNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UserNotFoundException_Exception(String message, UserNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: server.UserNotFoundException
     */
    public UserNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
