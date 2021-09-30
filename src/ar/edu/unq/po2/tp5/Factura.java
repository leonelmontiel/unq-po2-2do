package ar.edu.unq.po2.tp5;

public class Factura {
	private String descripcion;
	private double montoAPagar;
	
	public double getMontoAPagar() {
		return this.montoAPagar;
	}
	
	protected void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
