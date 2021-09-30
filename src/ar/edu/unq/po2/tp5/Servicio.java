package ar.edu.unq.po2.tp5;

public class Servicio extends Factura{
	private double costoXUnidad;
	private int cantUnidadesConsumidas;
	
	public Servicio(String descripcion, double costo, int cantidad) {
		setDescripcion(descripcion);
		setCosto(costo);
		setUnidadesConsumidas(cantidad);
	}

	private void setCosto(double costo) {
		this.costoXUnidad = costo;		
	}

	private void setUnidadesConsumidas(int cantidad) {
		this.cantUnidadesConsumidas = cantidad;
	}
	
	@Override
	public double getMontoAPagar() {
		double calculo = getCosto() * getUnidadesConsumidas();
		return calculo;
	}

	private double getCosto() {
		return this.costoXUnidad;
	}

	private int getUnidadesConsumidas() {
		return this.cantUnidadesConsumidas;
	}

}
