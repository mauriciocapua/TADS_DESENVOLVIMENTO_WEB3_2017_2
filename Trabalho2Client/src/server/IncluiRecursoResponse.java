
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de incluiRecursoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="incluiRecursoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="incluirecurso" type="{http://server/}recurso" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incluiRecursoResponse", propOrder = {
    "incluirecurso"
})
public class IncluiRecursoResponse {

    protected Recurso incluirecurso;

    /**
     * Obtém o valor da propriedade incluirecurso.
     * 
     * @return
     *     possible object is
     *     {@link Recurso }
     *     
     */
    public Recurso getIncluirecurso() {
        return incluirecurso;
    }

    /**
     * Define o valor da propriedade incluirecurso.
     * 
     * @param value
     *     allowed object is
     *     {@link Recurso }
     *     
     */
    public void setIncluirecurso(Recurso value) {
        this.incluirecurso = value;
    }

}
