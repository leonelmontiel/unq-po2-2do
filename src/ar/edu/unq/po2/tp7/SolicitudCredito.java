package ar.edu.unq.po2.tp7;

public abstract class SolicitudCredito {
	
	private Cliente cliente;
	private Float monto;
	private Integer plazo;
	
	public SolicitudCredito(Cliente cliente, Float monto, Integer plazo) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazo = plazo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Float getMonto() {
		return this.monto;
	}

	public Integer getPlazo() {
		return this.plazo;
	}
	
	public Float getCuotaMensual() {
		return this.getMonto() / this.getPlazo();
	}
	
	public boolean valorCuotaSuperaPorcentajeRequeridoDeSueldo(Double porcentaje) {
		return this.getCuotaMensual() > this.valorSueldoAplicadoPorcentajeRequerido(porcentaje);
	}

	public double valorSueldoAplicadoPorcentajeRequerido(Double porcentaje) {
		return this.getCliente().getSueldoNetoMensual() * this.getPorcentajeRequerido(porcentaje);
	}

	public double getPorcentajeRequerido(Double porcentaje) {
		return porcentaje / 100;
	}

	public abstract Boolean esAceptable();

}
