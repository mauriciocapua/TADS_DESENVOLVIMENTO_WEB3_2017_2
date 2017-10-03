package negocio;

public class Dado {
	private int userId;
	private int numero;

	public Dado(int userId, int numero) {
		this.userId = userId;
		this.numero = numero;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
