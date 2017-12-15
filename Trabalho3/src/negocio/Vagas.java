package negocio;

public class Vagas {
	private int id;
	private String serie;
	private int vagas;

	public Vagas() {
		super();
	}

	public Vagas(int id, String serie, int vagas) {
		super();
		this.id = id;
		this.serie = serie;
		this.vagas = vagas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

}
