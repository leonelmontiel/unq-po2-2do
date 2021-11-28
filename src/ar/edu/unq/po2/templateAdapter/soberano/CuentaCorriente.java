package ar.edu.unq.po2.templateAdapter.soberano;

public class CuentaCorriente extends CuentaBancaria {

	private int descubierto;

	public CuentaCorriente(int descubierto) {
		this.setDescubierto(descubierto);
	}

	private void setDescubierto(int descubierto) {
		this.descubierto = descubierto;		
	}

	@Override
	protected boolean validarExtraccion(int monto) {
		return this.saldoConLimiteEnRojo() >= monto;
	}

	private int saldoConLimiteEnRojo() {
		return this.getSaldo() + this.getDescubierto();
	}

	public int getDescubierto() {
		return this.descubierto;
	}

}
