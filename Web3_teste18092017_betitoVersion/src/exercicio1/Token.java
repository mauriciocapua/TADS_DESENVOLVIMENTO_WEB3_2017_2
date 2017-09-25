package exercicio1;

public class Token {
	private int id;
	private String login;
	private boolean status;
	private String validade;
	private String criacao;

	public Token() {
		this.id = 0;
		this.login = "";
		this.status = false;
		this.validade = "";
		this.criacao = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}
}
