package ar.edu.unq.po2.template.sueldo;

public class Planta extends Empleado {

	private int cantHijos;

	public Planta(int hijos) {
		super();
		this.setCantHijos(hijos);
	}

	private void setCantHijos(int hijos) {
		this.cantHijos = hijos;		
	}

	@Override
	protected Float bonoPorHijos() {
		return this.getCantHijos() * 150f;
	}

	private float getCantHijos() {
		return this.cantHijos;
	}

	@Override
	protected Float sueldoBasico() {
		return 3000f;
	}

	@Override
	protected Float montoHorasTrabajadas() {
		// Método HOOK
		return 0f;
	}

}
