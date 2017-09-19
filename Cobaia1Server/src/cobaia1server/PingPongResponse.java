
package cobaia1server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de pingPongResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="pingPongResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pingPongResponse", propOrder = {
    "pong"
})
public class PingPongResponse {

    protected String pong;

    /**
     * Obtém o valor da propriedade pong.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPong() {
        return pong;
    }

    /**
     * Define o valor da propriedade pong.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPong(String value) {
        this.pong = value;
    }

}
