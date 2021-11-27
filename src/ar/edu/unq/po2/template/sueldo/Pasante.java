package ar.edu.unq.po2.template.sueldo;

public class Pasante extends Empleado {

	private int horasTrabajadas;
	
	public Pasante(float sueldoBasico, int horasTrabajadas) {
		super(sueldoBasico);
		this.setHorasTrabajadas(horasTrabajadas);
	}

	private void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public Float montoHorasTrabajadas() {
		return this.getHorasTrabajadas() * this.valorPorHora();
	}

	private Float valorPorHora() {
		return 40f;
	}

	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	@Override
	protected Float extras() {
		return this.montoHorasTrabajadas();
	}

}
