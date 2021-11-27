package ar.edu.unq.po2.template.sueldo;

public class Temporario extends Empleado {

	private Integer horasTrabajadas;
	private Boolean esCasado;
	private int cantHijos;

	public Temporario(Float sueldoBasico, Integer horasTrabajadas, Boolean esCasado, int hijos) {
		super(sueldoBasico);
		this.setHorasTrabajadas(horasTrabajadas);
		this.setEsCasado(esCasado);
		this.setCantHijos(hijos);
	}

	private void setCantHijos(int hijos) {
		this.cantHijos = hijos;
	}

	private void setEsCasado(Boolean esCasado) {
		this.esCasado = esCasado;		
	}

	private void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;		
	}
	
	public Float bonoPorHijos() {
		return this.validarBonoPorHijos() ? 100f : 0f;
	}

	private Boolean validarBonoPorHijos() {
		return this.tieneHijos() || this.esCasado();
	}

	private Boolean esCasado() {
		return this.esCasado;
	}

	private Boolean tieneHijos() {
		return this.getCantHijos() > 0;
	}

	public int getCantHijos() {
		return this.cantHijos;
	}

	
	public Float montoHorasTrabajadas() {
		return this.getHorasTrabajadas() * 5f;
	}

	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	@Override
	protected Float extras() {		
		return this.montoHorasTrabajadas() + this.bonoPorHijos();
	}

}
