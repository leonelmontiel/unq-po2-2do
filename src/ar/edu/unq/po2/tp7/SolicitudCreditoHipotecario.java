package ar.edu.unq.po2.tp7;

public class SolicitudCreditoHipotecario extends SolicitudCredito {

	private Inmueble garantia;

	public SolicitudCreditoHipotecario(Cliente cliente, Float monto, Integer plazo, Inmueble garantia) {
		super(cliente, monto, plazo);
		this.garantia = garantia;
	}
	
	public Inmueble getGarantia() {
		return this.garantia;
	}

	@Override
	protected Boolean esAceptable() {
		// TODO Auto-generated method stub
		return null;
	}

}
