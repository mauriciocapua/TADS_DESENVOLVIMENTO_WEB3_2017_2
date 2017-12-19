package negocio;

import java.util.Date;

public class Matricula {
	private int id;
	private String nome;
	private String rg;
	private Date nascimento;
	private String serie;
	private String cep;
	private String endereco;
	private String bairro;
	private String nro;
	private Token token;
	private Date data;
	private Escola escola;

	public Matricula() {
		super();
	}

	public Matricula(int id, String nome, String rg, Date nascimento, String serie, String cep, String endereco,
			String bairro, String nro, Token token, Date data, Escola escola) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.nascimento = nascimento;
		this.serie = serie;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.nro = nro;
		this.token = token;
		this.data = data;
		this.escola = escola;
	}

	public Matricula(String nome, String rg, Date nascimento, String serie, String cep, String nro) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.nascimento = nascimento;
		this.serie = serie;
		this.cep = cep;
		this.nro = nro;
	}

	public Matricula(int id, String nome, String rg, Date nascimento, String serie, String cep, String endereco,
			String bairro, String nro, Token token, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.nascimento = nascimento;
		this.serie = serie;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.nro = nro;
		this.token = token;
		this.data = data;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", nome=" + nome + ", rg=" + rg + ", nascimento=" + nascimento + ", serie="
				+ serie + ", cep=" + cep + ", endereco=" + endereco + ", bairro=" + bairro + ", nro=" + nro + ", token="
				+ token + ", data=" + data + "]";
	}

}
