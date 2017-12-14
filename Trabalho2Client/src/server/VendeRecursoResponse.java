
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de vendeRecursoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="vendeRecursoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="venderecurso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vendeRecursoResponse", propOrder = {
    "venderecurso"
})
public class VendeRecursoResponse {

    protected boolean venderecurso;

    /**
     * Obtém o valor da propriedade venderecurso.
     * 
     */
    public boolean isVenderecurso() {
        return venderecurso;
    }

    /**
     * Define o valor da propriedade venderecurso.
     * 
     */
    public void setVenderecurso(boolean value) {
        this.venderecurso = value;
    }

}
