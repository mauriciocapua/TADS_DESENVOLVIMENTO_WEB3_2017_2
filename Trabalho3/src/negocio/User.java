package negocio;

public class User {
	private Integer id;
	private String login;
	private String senha;
	private Integer version;

	public User() {
	}

	public User(Integer id, String login, String senha, Integer version) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.version = version;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", senha=" + senha + ", version=" + version + "]";
	}

}
