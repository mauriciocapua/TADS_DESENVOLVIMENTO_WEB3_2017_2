package negocio;

public class Vaga {
	private int id;
	private int serie;
	private int quantidade;

	public Vaga() {
		super();
	}

	public Vaga(int id, int serie, int quantidade) {
		super();
		this.id = id;
		this.serie = serie;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", serie=" + serie + ", quantidade=" + quantidade + "]";
	}

}
