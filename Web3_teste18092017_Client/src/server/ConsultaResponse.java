
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dado" type="{http://server/}dado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaResponse", propOrder = {
    "dado"
})
public class ConsultaResponse {

    protected Dado dado;

    /**
     * Obtém o valor da propriedade dado.
     * 
     * @return
     *     possible object is
     *     {@link Dado }
     *     
     */
    public Dado getDado() {
        return dado;
    }

    /**
     * Define o valor da propriedade dado.
     * 
     * @param value
     *     allowed object is
     *     {@link Dado }
     *     
     */
    public void setDado(Dado value) {
        this.dado = value;
    }

}
