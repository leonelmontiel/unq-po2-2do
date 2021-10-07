package ar.edu.unq.po2.tp7;

public class Inmueble {

	private String descripcion;
	private String direccion;
	private Float valorFiscal;

	public Inmueble(String descripcion, String dir, Float valor) {
		this.descripcion = descripcion;
		this.direccion = dir;
		this.valorFiscal = valor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public Float getValorFiscal() {
		return this.valorFiscal;
	}

}
