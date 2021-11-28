package ar.edu.unq.po2.templateAdapter.soberano;

public class CajaAhorro extends CuentaBancaria{

	private int limite;

	public CajaAhorro(int limite) {
		this.setLimite(limite);
	}

	private void setLimite(int limite) {
		this.limite = limite;		
	}

	@Override
	protected boolean validarExtraccion(int monto) {
		return this.saldoMayorA(monto) && this.limiteMayorA(monto);
	}

	private Boolean limiteMayorA(int monto) {
		return this.getLimite() >= monto;
	}

	public int getLimite() {
		return this.limite;
	}

	private Boolean saldoMayorA(int monto) {
		return this.getSaldo() >= monto;
	}

}
