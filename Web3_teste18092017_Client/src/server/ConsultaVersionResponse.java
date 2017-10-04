
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaVersionResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaVersionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dado" type="{http://server/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaVersionResponse", propOrder = {
    "dado"
})
public class ConsultaVersionResponse {

    protected User dado;

    /**
     * Obtém o valor da propriedade dado.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getDado() {
        return dado;
    }

    /**
     * Define o valor da propriedade dado.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setDado(User value) {
        this.dado = value;
    }

}
