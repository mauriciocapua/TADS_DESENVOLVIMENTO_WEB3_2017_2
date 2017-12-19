package negocio;

import java.util.Date;

public class Periodo {
	private Date inicio;
	private Date fim;

	public Periodo() {
		super();
	}

	public Periodo(Date inicio, Date fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

}
