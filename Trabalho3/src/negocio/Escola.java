package negocio;

public class Escola {
	private int id;
	private String nome;
	private int cep;
	private String endereco;
	private String bairro;
	private int nro;

	public Escola() {
		super();
	}

	public Escola(int id, String nome, int cep, String endereco, String bairro, int nro) {
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

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
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

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

}
