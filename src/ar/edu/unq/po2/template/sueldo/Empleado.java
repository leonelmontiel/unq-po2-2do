package ar.edu.unq.po2.template.sueldo;

public abstract class Empleado {

	protected Float sueldo() {
		Float montoTotal = this.montoHorasTrabajadas() + this.sueldoBasico() + this.bonoPorHijos();
		return this.montoConDescuentos(montoTotal);
	}

	private Float montoConDescuentos(Float monto) {
		// el descuento por aportes y jubilación es del 13% del monto total
		return monto * 0.87f;
	}

	protected abstract Float bonoPorHijos();

	protected abstract Float sueldoBasico();

	protected abstract Float montoHorasTrabajadas();

}
