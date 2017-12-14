//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.10.24 às 09:53:04 PM BRST 
//


package negocio;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de token complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="token">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criacao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="validade" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "token", propOrder = {
    "criacao",
    "id",
    "login",
    "status",
    "validade"
})
public class Token {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date criacao;
    protected int id;
    @XmlElement(required = true)
    protected String login;
    protected boolean status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date validade;

    public Token(Integer id, String login, Boolean status, Date criacao, Date validade) {
		this.id = id;
		this.login = login;
		this.status = status;
		this.criacao = criacao;
		this.validade = validade;
	}

	public Token(String login, Boolean status, Date criacao, Date validade) {
		this.login = login;
		this.status = status;
		this.criacao = criacao;
		this.validade = validade;
	}

	/**
     * Obtém o valor da propriedade criacao.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCriacao() {
        return criacao;
    }

    /**
     * Define o valor da propriedade criacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCriacao(Date value) {
        this.criacao = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o valor da propriedade login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade validade.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * Define o valor da propriedade validade.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setValidade(Date value) {
        this.validade = value;
    }

}
