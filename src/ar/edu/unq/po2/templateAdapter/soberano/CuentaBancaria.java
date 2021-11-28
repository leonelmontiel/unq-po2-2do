package ar.edu.unq.po2.templateAdapter.soberano;

import java.util.List;

public abstract class CuentaBancaria {
	/*
	 * Solo realicé los cambios e implementé los métodos necesarios para esos cambios. Por ende, hay definiciones del código dado en el tp que no
	 * los tuve en cuenta en esta implementación
	 */
	
	private int saldo;
	private List<String> movimientos;

	// Template Method
	public void extraer(int monto) {
		/*
		 * Los cambios realizados son:
		 *  - nueva operación primitiva "validarExtraccion" para que cada subclase implemente la condición que permita el retiro del dinero
		 *  - nueva operaci+on concreta "actualizarSaldo" que settea el saldo anterior con el nuevo luego de la extracción
		 */
		if (this.validarExtraccion(monto)) {
			this.actualizarSaldo(monto);
			this.agregarMovimientos("Extraccion");
		}
	}

	// Operación concreta
	private void actualizarSaldo(int monto) {
		this.setSaldo(this.nuevoSaldo(monto));
	}

	// Operación concreta
	private void agregarMovimientos(String movimiento) {
		this.movimientos.add(movimiento);		
	}

	// Operación concreta
	private void setSaldo(int nuevoSaldo) {
		this.saldo = nuevoSaldo;		
	}

	// Hook Method
	protected int nuevoSaldo(int monto) {
		return this.getSaldo() - monto;
	}

	// Operación concreta
	protected int getSaldo() {
		return this.saldo;
	}

	// Operación primitiva
	protected abstract boolean validarExtraccion(int monto);

}
