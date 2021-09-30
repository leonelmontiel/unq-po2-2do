package ar.edu.unq.po2.tp5;

public class Impuesto extends Factura {
	private double tasa; //valor fijo en pesos
	
	public Impuesto(String descripcion, double tasa) {
		setDescripcion(descripcion);
		setTasa(tasa);
	}

	private void setTasa(double tasa) {
		this.tasa = tasa;
	}
	
	@Override
	public double getMontoAPagar() {
		return getTasa();		
	}

	private double getTasa() {
		return this.tasa;
	}
	
	

}
