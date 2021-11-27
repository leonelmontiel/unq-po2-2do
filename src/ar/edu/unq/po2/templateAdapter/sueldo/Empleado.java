package ar.edu.unq.po2.templateAdapter.sueldo;

public abstract class Empleado {
	
	private Float sueldoBasico;
	
	public Empleado(Float sueldoBasico) {
		// todas sus subclases deben indicar por parámetro cuánto es el valor de su sueldo básico
		this.setSueldoBasico(sueldoBasico);
	}

	protected void setSueldoBasico(Float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;		
	}

	protected Float sueldo() {
		Float montoTotal = this.getSueldoBasico() + this.extras();
		return this.montoConDescuentos(montoTotal);
	}

	private Float montoConDescuentos(Float monto) {
		// el descuento por aportes y jubilación es del 13% del monto total
		return monto * this.descuentoRetenciones();
	}

	private float descuentoRetenciones() {
		return 0.87f;
	}
	protected abstract Float extras();
	
	protected Float getSueldoBasico() {
		return this.sueldoBasico;
	}
}
