package ar.edu.unq.po2.tp4;

public class IngresoHorasExtras extends Ingreso {

	private int horasExtras;

	public IngresoHorasExtras(String mes, String concepto, double monto, int horasExtras) {
		super(mes, concepto, monto);
		this.setHorasExtras(horasExtras);
	}

	private void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;		
	}
	
	@Override
	public Double getMontoImponible() {
		return 0.0;
	}

}
