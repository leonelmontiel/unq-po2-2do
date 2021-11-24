package ar.edu.unq.po2.template.sueldo;

public class Temporario extends Empleado {

	private Integer horasTrabajadas;
	private Boolean esCasado;
	private int cantHijos;

	public Temporario(Integer horasTrabajadas, Boolean esCasado, int hijos) {
		super();
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

	@Override
	protected Float bonoPorHijos() {
		/* NO ME CIERRA ESTO DE USAR DOS RETURN */
		if (this.validarBonoPorHijos()) {
			return 1000f;
		} return 0f;
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

	@Override
	protected Float sueldoBasico() {
		return 1000f;
	}

	@Override
	protected Float montoHorasTrabajadas() {
		return this.getHorasTrabajadas() * 5f;
	}

	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

}
