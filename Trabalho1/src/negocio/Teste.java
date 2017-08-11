package negocio;

public class Teste {
	private String name;
	private String city;
	private String cars;

	private String job;

	public Teste() {

	}

	public Teste(String name, String city, String cars, String job) {
		super();
		this.name = name;
		this.city = city;
		this.cars = cars;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
