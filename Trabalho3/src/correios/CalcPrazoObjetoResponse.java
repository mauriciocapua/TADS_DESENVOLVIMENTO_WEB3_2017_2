
package correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalcPrazoObjetoResult" type="{http://tempuri.org/}cResultadoObjeto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "calcPrazoObjetoResult"
})
@XmlRootElement(name = "CalcPrazoObjetoResponse")
public class CalcPrazoObjetoResponse {

    @XmlElement(name = "CalcPrazoObjetoResult", required = true)
    protected CResultadoObjeto calcPrazoObjetoResult;

    /**
     * Obt�m o valor da propriedade calcPrazoObjetoResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultadoObjeto }
     *     
     */
    public CResultadoObjeto getCalcPrazoObjetoResult() {
        return calcPrazoObjetoResult;
    }

    /**
     * Define o valor da propriedade calcPrazoObjetoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultadoObjeto }
     *     
     */
    public void setCalcPrazoObjetoResult(CResultadoObjeto value) {
        this.calcPrazoObjetoResult = value;
    }

}
