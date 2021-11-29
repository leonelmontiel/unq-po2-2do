package ar.edu.unq.po2.refactoring.cuenta;

public abstract class CuentaBancaria {
	
	/*
	 * En la implementacón original pude notar que extraer puede ser un template method, ya que las subclases comparten la misma estructura
	 * para realizar la acción, solo que cada una sabe como se debe cumplir la condición.
	 * También veo que se obtiene y se configura directamente las variables de instancia, es decir, no se hacen uso de los accesores get y set
	 */
	
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public void extraer(Integer monto) {
		if(cumpleCondicion(monto)) {
			this.decrementarSaldo(monto);
			this.registrarMovimiento(monto);
			this.notificarNuevoSaldo();
		}
	}

	private void notificarNuevoSaldo() {
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	private void registrarMovimiento(Integer monto) {
		this.historialDeMovimientos.registrarMovimiento("Extracción", monto);
	}

	private void decrementarSaldo(Integer monto) {
		this.setSaldo(this.getSaldo() - monto);
	}

	private void setSaldo(Integer nuevoSaldo) {
		this.saldo = nuevoSaldo;		
	}

	protected abstract boolean cumpleCondicion(Integer monto);
}
