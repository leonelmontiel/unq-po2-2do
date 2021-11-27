package ar.edu.unq.po2.template.sueldo;

public abstract class Empleado {
	
	private Float sueldoBasico;
	
	public Empleado(Float sueldoBasico) {
		this.setSueldoBasico(sueldoBasico);
	}

	protected void setSueldoBasico(Float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;		
	}

	protected Float sueldo() {
		Float montoTotal = this.getSueldoBasico() + this.extras();
		// this.sueldoBasico() + this.extras();
		return this.montoConDescuentos(montoTotal);
	}

	private Float montoConDescuentos(Float monto) {
		// el descuento por aportes y jubilación es del 13% del monto total
		return monto * 0.87f;
	}
	protected abstract Float extras();
	
	protected Float getSueldoBasico() {
		return this.sueldoBasico;
	}
}
