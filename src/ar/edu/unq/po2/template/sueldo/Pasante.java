package ar.edu.unq.po2.template.sueldo;

public class Pasante extends Empleado {

	private int horasTrabajadas;
	
	public Pasante(int horasTrabajadas) {
		super();
		this.setHorasTrabajadas(horasTrabajadas);
	}

	private void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	protected Float bonoPorHijos() {
		// M�todo HOOK
		return 0f;
	}

	@Override
	protected Float sueldoBasico() {
		// M�todo HOOK
		return 0f;
	}

	@Override
	protected Float montoHorasTrabajadas() {
		return this.getHorasTrabajadas() * 40f;
	}

	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

}
