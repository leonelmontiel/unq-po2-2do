package ar.edu.unq.po2.templateAdapter.soberano;

import java.util.List;

public abstract class CuentaBancaria {
	/*
	 * Solo realic� los cambios e implement� los m�todos necesarios para esos cambios. Por ende, hay definiciones del c�digo dado en el tp que no
	 * los tuve en cuenta en esta implementaci�n
	 */
	
	private int saldo;
	private List<String> movimientos;

	// Template Method
	public void extraer(int monto) {
		/*
		 * Los cambios realizados son:
		 *  - nueva operaci�n primitiva "validarExtraccion" para que cada subclase implemente la condici�n que permita el retiro del dinero
		 *  - nueva operaci+on concreta "actualizarSaldo" que settea el saldo anterior con el nuevo luego de la extracci�n
		 */
		if (this.validarExtraccion(monto)) {
			this.actualizarSaldo(monto);
			this.agregarMovimientos("Extraccion");
		}
	}

	// Operaci�n concreta
	private void actualizarSaldo(int monto) {
		this.setSaldo(this.nuevoSaldo(monto));
	}

	// Operaci�n concreta
	private void agregarMovimientos(String movimiento) {
		this.movimientos.add(movimiento);		
	}

	// Operaci�n concreta
	private void setSaldo(int nuevoSaldo) {
		this.saldo = nuevoSaldo;		
	}

	// Hook Method
	protected int nuevoSaldo(int monto) {
		return this.getSaldo() - monto;
	}

	// Operaci�n concreta
	protected int getSaldo() {
		return this.saldo;
	}

	// Operaci�n primitiva
	protected abstract boolean validarExtraccion(int monto);

}
