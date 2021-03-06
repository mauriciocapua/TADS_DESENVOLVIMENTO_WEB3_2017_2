
package server;

import java.util.List;
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
@WebService(name = "UserWS", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns server.Token
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createToken", targetNamespace = "http://server/", className = "server.CreateToken")
    @ResponseWrapper(localName = "createTokenResponse", targetNamespace = "http://server/", className = "server.CreateTokenResponse")
    @Action(input = "http://server/UserWS/createTokenRequest", output = "http://server/UserWS/createTokenResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/UserWS/createToken/Fault/Exception")
    })
    public Token createToken(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param senha
     * @param login
     * @return
     *     returns java.util.List<server.Token>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "verifyToken", targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://server/", className = "server.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://server/", className = "server.LoginResponse")
    @Action(input = "http://server/UserWS/loginRequest", output = "http://server/UserWS/loginResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/UserWS/login/Fault/Exception")
    })
    public List<Token> login(
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "senha", targetNamespace = "")
        String senha)
        throws Exception_Exception
    ;

}
