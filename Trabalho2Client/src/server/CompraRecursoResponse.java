
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de compraRecursoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="compraRecursoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comprarecurso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compraRecursoResponse", propOrder = {
    "comprarecurso"
})
public class CompraRecursoResponse {

    protected boolean comprarecurso;

    /**
     * Obtém o valor da propriedade comprarecurso.
     * 
     */
    public boolean isComprarecurso() {
        return comprarecurso;
    }

    /**
     * Define o valor da propriedade comprarecurso.
     * 
     */
    public void setComprarecurso(boolean value) {
        this.comprarecurso = value;
    }

}
