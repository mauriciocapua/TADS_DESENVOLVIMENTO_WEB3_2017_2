
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

    private final static QName _RecursoNotFound_QNAME = new QName("http://server/", "RecursoNotFound");
    private final static QName _VendeRecurso_QNAME = new QName("http://server/", "vendeRecurso");
    private final static QName _VendeRecursoResponse_QNAME = new QName("http://server/", "vendeRecursoResponse");
    private final static QName _ConsultaRecurso_QNAME = new QName("http://server/", "consultaRecurso");
    private final static QName _ConsultaRecursoResponse_QNAME = new QName("http://server/", "consultaRecursoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaRecurso }
     * 
     */
    public ConsultaRecurso createConsultaRecurso() {
        return new ConsultaRecurso();
    }

    /**
     * Create an instance of {@link ConsultaRecursoResponse }
     * 
     */
    public ConsultaRecursoResponse createConsultaRecursoResponse() {
        return new ConsultaRecursoResponse();
    }

    /**
     * Create an instance of {@link VendeRecursoResponse }
     * 
     */
    public VendeRecursoResponse createVendeRecursoResponse() {
        return new VendeRecursoResponse();
    }

    /**
     * Create an instance of {@link VendeRecurso }
     * 
     */
    public VendeRecurso createVendeRecurso() {
        return new VendeRecurso();
    }

    /**
     * Create an instance of {@link RecursoNotFound }
     * 
     */
    public RecursoNotFound createRecursoNotFound() {
        return new RecursoNotFound();
    }

    /**
     * Create an instance of {@link Recurso }
     * 
     */
    public Recurso createRecurso() {
        return new Recurso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecursoNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "RecursoNotFound")
    public JAXBElement<RecursoNotFound> createRecursoNotFound(RecursoNotFound value) {
        return new JAXBElement<RecursoNotFound>(_RecursoNotFound_QNAME, RecursoNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VendeRecurso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "vendeRecurso")
    public JAXBElement<VendeRecurso> createVendeRecurso(VendeRecurso value) {
        return new JAXBElement<VendeRecurso>(_VendeRecurso_QNAME, VendeRecurso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VendeRecursoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "vendeRecursoResponse")
    public JAXBElement<VendeRecursoResponse> createVendeRecursoResponse(VendeRecursoResponse value) {
        return new JAXBElement<VendeRecursoResponse>(_VendeRecursoResponse_QNAME, VendeRecursoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaRecurso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consultaRecurso")
    public JAXBElement<ConsultaRecurso> createConsultaRecurso(ConsultaRecurso value) {
        return new JAXBElement<ConsultaRecurso>(_ConsultaRecurso_QNAME, ConsultaRecurso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaRecursoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "consultaRecursoResponse")
    public JAXBElement<ConsultaRecursoResponse> createConsultaRecursoResponse(ConsultaRecursoResponse value) {
        return new JAXBElement<ConsultaRecursoResponse>(_ConsultaRecursoResponse_QNAME, ConsultaRecursoResponse.class, null, value);
    }

}
