package ReflectionExamples;

public class EjemploBean {

	public String nombre = "Keko";
	private String email = "keko@miservidor.es";

	private void setNombre(String s) {
		nombre = s;
	}

	protected String getNombre() {
		return nombre;
	}

	public void setEmail(String s) {
		email = s;
	}

	public String getEmail() {
		return email;
	}
}