
package cobaia1server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cobaia1server package. 
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

    private final static QName _Ping3Response_QNAME = new QName("http://cobaia1server/", "ping3Response");
    private final static QName _PingPong_QNAME = new QName("http://cobaia1server/", "pingPong");
    private final static QName _PingPongResponse_QNAME = new QName("http://cobaia1server/", "pingPongResponse");
    private final static QName _Ping3_QNAME = new QName("http://cobaia1server/", "ping3");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cobaia1server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PingPong }
     * 
     */
    public PingPong createPingPong() {
        return new PingPong();
    }

    /**
     * Create an instance of {@link PingPongResponse }
     * 
     */
    public PingPongResponse createPingPongResponse() {
        return new PingPongResponse();
    }

    /**
     * Create an instance of {@link Ping3Response }
     * 
     */
    public Ping3Response createPing3Response() {
        return new Ping3Response();
    }

    /**
     * Create an instance of {@link Ping3 }
     * 
     */
    public Ping3 createPing3() {
        return new Ping3();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cobaia1server/", name = "ping3Response")
    public JAXBElement<Ping3Response> createPing3Response(Ping3Response value) {
        return new JAXBElement<Ping3Response>(_Ping3Response_QNAME, Ping3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingPong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cobaia1server/", name = "pingPong")
    public JAXBElement<PingPong> createPingPong(PingPong value) {
        return new JAXBElement<PingPong>(_PingPong_QNAME, PingPong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingPongResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cobaia1server/", name = "pingPongResponse")
    public JAXBElement<PingPongResponse> createPingPongResponse(PingPongResponse value) {
        return new JAXBElement<PingPongResponse>(_PingPongResponse_QNAME, PingPongResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cobaia1server/", name = "ping3")
    public JAXBElement<Ping3> createPing3(Ping3 value) {
        return new JAXBElement<Ping3>(_Ping3_QNAME, Ping3 .class, null, value);
    }

}
