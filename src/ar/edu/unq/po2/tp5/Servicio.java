package ar.edu.unq.po2.tp5;

public class Servicio implements Factura{
	private double costoXUnidad;
	private int cantUnidadesConsumidas;
	
	public Servicio(double costo, int cantidad) {
		setCosto(costo);
		setUnidadesConsumidas(cantidad);
	}

	private void setCosto(double costo) {
		this.costoXUnidad = costo;		
	}

	private void setUnidadesConsumidas(int cantidad) {
		this.cantUnidadesConsumidas = cantidad;
	}

	private double getCosto() {
		return this.costoXUnidad;
	}

	private int getUnidadesConsumidas() {
		return this.cantUnidadesConsumidas;
	}
	
	@Override
	public double getMontoAPagar() {
		double calculo = getCosto() * getUnidadesConsumidas();
		return calculo;
	}

}
