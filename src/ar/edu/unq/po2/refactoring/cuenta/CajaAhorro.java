package ar.edu.unq.po2.refactoring.cuenta;

public class CajaAhorro extends CuentaBancaria{

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
	}

	// implementa el hook method del template en la clase padre
	@Override
	protected boolean cumpleCondicion(Integer monto) {
		return this.getSaldo() >= monto;
	}	
	
	/* ESTO YA NO ES NECESARIO PORQUE AHORA EXISTE EL MÉTODO PLANTILLA
	 @Override
	public void extraer(Integer monto) {
		if(this.saldo >= monto) {
			this.saldo = saldo - monto;
			this.historialDeMovimientos.registrarMovimiento("Extracción", monto);
			this.notificador.notificarNuevoSaldoACliente(this);
		}
	}
	 */

}
