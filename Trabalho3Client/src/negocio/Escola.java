package negocio;

public class Escola {
	private int id;
	private String nome;
	private String cep;
	private String endereco;
	private String bairro;
	private String nro;

	public Escola() {
		super();
	}

	public Escola(int id) {
		super();
		this.id = id;
	}

	public Escola(int id, String nome, String cep, String endereco, String bairro, String nro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.nro = nro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

}
