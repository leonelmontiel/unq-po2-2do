package ar.edu.unq.po2.tp7;

public class SolicitudHipotecario extends SolicitudCredito {

	private Inmueble garantia;
	
	public SolicitudHipotecario(Cliente cliente, Float monto, Integer plazo, Inmueble garantia) {
		super(cliente, monto, plazo);
		this.garantia = garantia;
	}

	public Inmueble getGarantia() {
		return this.garantia;
	}

	@Override
	public Boolean esAceptable() {
		return !this.valorCuotaSuperaPorcentajeRequeridoDeSueldo(50.0) && 
				this.montoSolicitadoMenorAlProcentajeLimiteValorFiscal(70.0) && 
				this.clienteMenorDe(65);
	}

	private boolean montoSolicitadoMenorAlProcentajeLimiteValorFiscal(Double porcentaje) {
		return !(this.getMonto() > this.getPorcentajeValorFiscal(porcentaje));
	}

	public double getPorcentajeValorFiscal(Double porcentaje) {
		return this.getGarantia().getValorFiscal() * this.getPorcentajeRequerido(porcentaje);
	}

	private boolean clienteMenorDe(Integer edadLimite) {
		return edadClienteAlFinalizarCredito() < edadLimite;
	}

	public int edadClienteAlFinalizarCredito() {
		return this.getCliente().getEdad() + this.getPlazoEnAños();
	}

	public int getPlazoEnAños() {
		return this.getPlazo() / 12;
	}

	
}
