package negocio;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	String codigo;
	String linguagem;
	List<Titulo> titulo;
	String publicacao;
	String editora;
	int quantidadeDeAutores;
	List<String> autores;
	Capa capa;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Titulo> getTitulo() {
		return titulo;
	}

	public void setTitulo(List<Titulo> titulo) {
		this.titulo = titulo;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getQuantidadeDeAutores() {
		return quantidadeDeAutores;
	}

	public void setQuantidadeDeAutores(int quantidadeDeAutores) {
		this.quantidadeDeAutores = quantidadeDeAutores;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public Capa getCapa() {
		return capa;
	}

	public void setCapa(Capa capa) {
		this.capa = capa;
	}


	

	


}
