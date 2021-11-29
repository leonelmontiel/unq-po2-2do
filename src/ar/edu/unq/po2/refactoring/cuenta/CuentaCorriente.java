package ar.edu.unq.po2.refactoring.cuenta;

public class CuentaCorriente extends CuentaBancaria{
	private Integer limiteDescubierto;
	
	public CuentaCorriente(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo, Integer limiteDescubierto) {
		super(historialDeMovimientos, notificador, saldo);
		this.limiteDescubierto = limiteDescubierto;
	}
	
	@Override
	public boolean cumpleCondicion(Integer monto) {
		return saldoConLimiteEnRojo() >= monto;
	}

	private int saldoConLimiteEnRojo() {
		return this.getSaldo() + this.getLimite();
	}

	private int getLimite() {
		return this.limiteDescubierto;
	}	
	
	/* ESTO YA NO ES NECESARIO PORQUE AHORA EXISTE EL M…TODO PLANTILLA
	@Override
	public void extraer(Integer monto) {
		if(this.saldo + this.limiteDescubierto >= monto)
			this.saldo = saldo - monto;
			this.historialDeMovimientos.registrarMovimiento("Extracci√≥n", monto);
			this.notificador.notificarNuevoSaldoACliente(this);
	}
	*/

}
