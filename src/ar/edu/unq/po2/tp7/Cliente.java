package ar.edu.unq.po2.tp7;


public class Cliente {

	private static final String INVALID_NAME = "El nombre no puede estar en blanco";
	private String nombre;
	private String apellido;
	private Integer edad;
	private String direccion;
	private Float sueldoNetoMensual;

	public Cliente(String nombre, String apellido, Integer edad, String direccion, Float sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.sueldoNetoMensual = sueldo;
	}

	public Cliente(String string) {
		this.nombre = string;
	}
	
	public static Cliente nuevo(String string) {
		assertIsValidName(string);
		return new Cliente(string);
	}

	private static void assertIsValidName(String string) {
		if (!isValidName(string)) throw new RuntimeException(INVALID_NAME);
	}

	private static boolean isValidName(String string) {
		return !string.isBlank();
	}
	
	////////////////////

	public String getNombre() {
		return this.nombre;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public Float getSueldoNetoMensual() {
		return this.sueldoNetoMensual;
	}

	public String getApellido() {
		return this.apellido;
	}

	public Float getSueldoNetoAnual() {
		return getSueldoNetoMensual() * 12;
	}

}
