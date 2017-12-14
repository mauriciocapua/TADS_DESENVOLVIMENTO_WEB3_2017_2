
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaRecursoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaRecursoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consultarecurso" type="{http://server/}recurso" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaRecursoResponse", propOrder = {
    "consultarecurso"
})
public class ConsultaRecursoResponse {

    protected Recurso consultarecurso;

    /**
     * Obtém o valor da propriedade consultarecurso.
     * 
     * @return
     *     possible object is
     *     {@link Recurso }
     *     
     */
    public Recurso getConsultarecurso() {
        return consultarecurso;
    }

    /**
     * Define o valor da propriedade consultarecurso.
     * 
     * @param value
     *     allowed object is
     *     {@link Recurso }
     *     
     */
    public void setConsultarecurso(Recurso value) {
        this.consultarecurso = value;
    }

}
