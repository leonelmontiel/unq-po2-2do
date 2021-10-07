package ar.edu.unq.po2.tp7;

abstract public class SolicitudCredito {

	private Cliente cliente;
	private Float monto;
	private Integer plazo;

	public SolicitudCredito(Cliente cliente, Float monto, Integer plazo) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazo = plazo;
	}

	public Float getMonto() {
		return this.monto;
	}

	public Integer getPlazo() {
		return this.plazo;
	}

	public Float getCuotaMensual() {
		return getMonto() / getPlazo();
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	protected abstract Boolean esAceptable();

}
