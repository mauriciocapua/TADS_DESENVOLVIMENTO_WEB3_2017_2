
package server;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RecursoNotInsert", targetNamespace = "http://server/")
public class RecursoNotInsert_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RecursoNotInsert faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public RecursoNotInsert_Exception(String message, RecursoNotInsert faultInfo) {
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public RecursoNotInsert_Exception(String message, RecursoNotInsert faultInfo, Throwable cause) {
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: server.RecursoNotInsert
     */
    public RecursoNotInsert getFaultInfo() {
        return faultInfo;
    }

}
