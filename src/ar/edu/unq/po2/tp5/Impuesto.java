package ar.edu.unq.po2.tp5;

public class Impuesto implements Factura {
	private double tasa; //valor fijo en pesos
	public Impuesto(double tasa) {
		setTasa(tasa);
	}

	private void setTasa(double tasa) {
		this.tasa = tasa;
	}

	private double getTasa() {
		return this.tasa;
	}
	
	@Override
	public double getMontoAPagar() {
		return getTasa();		
	}

}
