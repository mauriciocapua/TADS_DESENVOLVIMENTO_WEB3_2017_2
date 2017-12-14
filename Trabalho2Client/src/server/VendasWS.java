
package server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VendasWS", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VendasWS {


    /**
     * 
     * @param venda
     * @param idRecurso
     * @param version
     * @return
     *     returns boolean
     * @throws RecursoNotFound_Exception
     */
    @WebMethod
    @WebResult(name = "venderecurso", targetNamespace = "")
    @RequestWrapper(localName = "vendeRecurso", targetNamespace = "http://server/", className = "server.VendeRecurso")
    @ResponseWrapper(localName = "vendeRecursoResponse", targetNamespace = "http://server/", className = "server.VendeRecursoResponse")
    @Action(input = "http://server/VendasWS/vendeRecursoRequest", output = "http://server/VendasWS/vendeRecursoResponse", fault = {
    })
    public boolean vendeRecurso(
        @WebParam(name = "idRecurso", targetNamespace = "")
        String idRecurso,
        @WebParam(name = "venda", targetNamespace = "")
        String venda,
        @WebParam(name = "version", targetNamespace = "")
        String version)
    ;

    /**
     * 
     * @param id
     * @param quantidade
     * @return
     *     returns server.Recurso
     * @throws RecursoNotFound_Exception
     */
    @WebMethod
    @WebResult(name = "consultarecurso", targetNamespace = "")
    @RequestWrapper(localName = "consultaRecurso", targetNamespace = "http://server/", className = "server.ConsultaRecurso")
    @ResponseWrapper(localName = "consultaRecursoResponse", targetNamespace = "http://server/", className = "server.ConsultaRecursoResponse")
    @Action(input = "http://server/VendasWS/consultaRecursoRequest", output = "http://server/VendasWS/consultaRecursoResponse", fault = {
    })
    public Recurso consultaRecurso(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "quantidade", targetNamespace = "")
        String quantidade)
    ;

}