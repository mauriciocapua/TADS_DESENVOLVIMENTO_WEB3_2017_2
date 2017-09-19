package negocio;

import java.sql.Timestamp;

public class Token {
	private Integer id;
	private String login;
	private Boolean status;
	private Timestamp validade;
	private Timestamp criacao;

	public Token() {
	}

	public Token(Integer id, String login, Boolean status, Timestamp validade, Timestamp criacao) {
		this.id = id;
		this.login = login;
		this.status = status;
		this.validade = validade;
		this.criacao = criacao;
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

	public Timestamp getValidade() {
		return validade;
	}

	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}

	public Timestamp getCriacao() {
		return criacao;
	}

	public void setCriacao(Timestamp criacao) {
		this.criacao = criacao;
	}

}
