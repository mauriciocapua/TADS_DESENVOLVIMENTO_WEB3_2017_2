
package server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://server/", "Exception");
    private final static QName _Login_QNAME = new QName("http://server/", "login");
    private final static QName _CreateToken_QNAME = new QName("http://server/", "createToken");
    private final static QName _ListAllResponse_QNAME = new QName("http://server/", "listAllResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://server/", "loginResponse");
    private final static QName _UserNotFoundException_QNAME = new QName("http://server/", "UserNotFoundException");
    private final static QName _ConsultaVersion_QNAME = new QName("http://server/", "consultaVersion");
    private final static QName _CreateTokenResponse_QNAME = new QName("http://server/", "createTokenResponse");
    private final static QName _TokenValidNotFoundException_QNAME = new QName("http://server/", "TokenValidNotFoundException");
    private final static QName _Consulta_QNAME = new QName("http://server/", "consulta");
    private final static QName _ConsultaVersionResponse_QNAME = new QName("http://server/", "consultaVersionResponse");
    private final static QName _ListById_QNAME = new QName("http://server/", "listById");
    private final static QName _ListByIdResponse_QNAME = new QName("http://server/", "listByIdResponse");
    private final static QName _ListAll_QNAME = new QName("http://server/", "listAll");
    private final static QName _UserAuthenticationException_QNAME = new QName("http://server/", "UserAuthenticationException");
    private final static QName _ConsultaResponse_QNAME = new QName("http://server/", "consultaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserNotFoundException }
     * 
     */
    public UserNotFoundException createUserNotFoundException() {
        return new UserNotFoundException();
    }

    /**
     * Create an instance of {@link ConsultaVersion }
     * 
     */
    public ConsultaVersion createConsultaVersion() {
        return new ConsultaVersion();
    }

    /**
     * Create an instance of {@link CreateTokenResponse }
     * 
     */
    public CreateTokenResponse createCreateTokenResponse() {
        return new CreateTokenResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link ListAllResponse }
     * 
     */
    public ListAllResponse createListAllResponse() {
        return new ListAllResponse();
    }

    /**
     * Create an instance of {@link CreateToken }
     * 
     */
    public CreateToken createCreateToken() {
        return new CreateToken();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link UserAuthenticationException }
     * 
     */
    public UserAuthenticationException createUserAuthenticationException() {
        return new UserAuthenticationException();
    }

    /**
     * Create an instance of {@link ConsultaResponse }
     * 
     */
    public ConsultaResponse createConsultaResponse() {
        return new ConsultaResponse();
    }

    /**
     * Create an instance of {@link ListByIdResponse }
     * 
     */
    public ListByIdResponse createListByIdResponse() {
        return new ListByIdResponse();
    }

    /**
     * Create an instance of {@link ListAll }
     * 
     */
    public ListAll createListAll() {
        return new ListAll();
    }

    /**
     * Create an instance of {@link TokenValidNotFoundException }
     * 
     */
    public TokenValidNotFoundException createTokenValidNotFoundException() {
        return new TokenValidNotFoundException();
    }

    /**
     * Create an instance of {@link Consulta }
     * 
     */
    public Consulta createConsulta() {
        return new Consulta();
    }

    /**
     * Create an instance of {@link ConsultaVersionResponse }
     * 
     */
    public ConsultaVersionResponse createConsultaVersionResponse() {
        return new ConsultaVersionResponse();
    }

    /**
     * Create an instance of {@link ListById }
     * 
     */
    public ListById createListById() {
        return new ListById();
    }

    /**
     * Create an instance of {@link Dado }
     * 
     */
    public Dado createDado() {
        return new Dado();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "createToken")
    public JAXBElement<CreateToken> createCreateToken(CreateToken value) {
        return new JAXBElement<CreateToken>(_CreateToken_QNAME, CreateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "listAllResponse")
    public JAXBElement<ListAllResponse> createListAllResponse(ListAllResponse value) {
        return new JAXBElement<ListAllResponse>(_ListAllResponse_QNAME, ListAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "UserNotFoundException")
    public JAXBElement<UserNotFoundException> createUserNotFoundException(UserNotFoundException value) {
        return new JAXBElement<UserNotFoundException>(_UserNotFoundException_QNAME, UserNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consultaVersion")
    public JAXBElement<ConsultaVersion> createConsultaVersion(ConsultaVersion value) {
        return new JAXBElement<ConsultaVersion>(_ConsultaVersion_QNAME, ConsultaVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "createTokenResponse")
    public JAXBElement<CreateTokenResponse> createCreateTokenResponse(CreateTokenResponse value) {
        return new JAXBElement<CreateTokenResponse>(_CreateTokenResponse_QNAME, CreateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenValidNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "TokenValidNotFoundException")
    public JAXBElement<TokenValidNotFoundException> createTokenValidNotFoundException(TokenValidNotFoundException value) {
        return new JAXBElement<TokenValidNotFoundException>(_TokenValidNotFoundException_QNAME, TokenValidNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consulta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consulta")
    public JAXBElement<Consulta> createConsulta(Consulta value) {
        return new JAXBElement<Consulta>(_Consulta_QNAME, Consulta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaVersionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consultaVersionResponse")
    public JAXBElement<ConsultaVersionResponse> createConsultaVersionResponse(ConsultaVersionResponse value) {
        return new JAXBElement<ConsultaVersionResponse>(_ConsultaVersionResponse_QNAME, ConsultaVersionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "listById")
    public JAXBElement<ListById> createListById(ListById value) {
        return new JAXBElement<ListById>(_ListById_QNAME, ListById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "listByIdResponse")
    public JAXBElement<ListByIdResponse> createListByIdResponse(ListByIdResponse value) {
        return new JAXBElement<ListByIdResponse>(_ListByIdResponse_QNAME, ListByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "listAll")
    public JAXBElement<ListAll> createListAll(ListAll value) {
        return new JAXBElement<ListAll>(_ListAll_QNAME, ListAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthenticationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "UserAuthenticationException")
    public JAXBElement<UserAuthenticationException> createUserAuthenticationException(UserAuthenticationException value) {
        return new JAXBElement<UserAuthenticationException>(_UserAuthenticationException_QNAME, UserAuthenticationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consultaResponse")
    public JAXBElement<ConsultaResponse> createConsultaResponse(ConsultaResponse value) {
        return new JAXBElement<ConsultaResponse>(_ConsultaResponse_QNAME, ConsultaResponse.class, null, value);
    }

}
