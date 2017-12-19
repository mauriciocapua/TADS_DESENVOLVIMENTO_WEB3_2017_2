package negocio;

import java.util.Date;

public class Token {
	private Integer id;
	private String login;
	private Boolean status;
	private Date criacao;
	private Date validade;

	public Token() {
		super();
	}

	public Token(Integer id) {
		super();
		this.id = id;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

}
