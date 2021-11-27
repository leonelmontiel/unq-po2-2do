package ar.edu.unq.po2.template.sueldo;

public class Planta extends Empleado {

	private int cantHijos;

	public Planta(Float sueldoBasico, int hijos) {
		super(sueldoBasico);
		this.setCantHijos(hijos);
	}

	private void setCantHijos(int hijos) {
		this.cantHijos = hijos;		
	}

	public Float bonoPorHijos() {
		return this.getCantHijos() * this.valorPorHijo();
	}

	private Float valorPorHijo() {
		return 150f;
	}

	private float getCantHijos() {
		return this.cantHijos;
	}

	@Override
	protected Float extras() {
		return this.bonoPorHijos();
	}

}
