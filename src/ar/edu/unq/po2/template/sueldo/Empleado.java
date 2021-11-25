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
		// el descuento por aportes y jubilaci�n es del 13% del monto total
		return monto * 0.87f;
	}

	// CREAR UN MET�DO "EXTRAS" QUE IMPLEMENTEN ESTAS FUNCIONES
	protected abstract Float extras();
	
	//protected abstract Float bonoPorHijos(); //extra

	protected Float getSueldoBasico() {
		return this.sueldoBasico;
	}

	//protected abstract Float montoHorasTrabajadas(); //extra

}
