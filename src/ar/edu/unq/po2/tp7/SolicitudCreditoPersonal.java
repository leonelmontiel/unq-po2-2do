package ar.edu.unq.po2.tp7;

public class SolicitudCreditoPersonal extends SolicitudCredito {

	public SolicitudCreditoPersonal(Cliente cliente, Float monto, Integer plazo) {
		super(cliente, monto, plazo);
	}

	@Override
	protected Boolean esAceptable() {
		return sueldoAnualSupera_(15000f) && clienteCumpleRequerimientoDeSueldo();
	}

	//CREAR TEST POR CADA CONDICIÓN
	
	private boolean clienteCumpleRequerimientoDeSueldo() {
		return this.getCuotaMensual() < setentaPorCientoSueldoMensualCliente();
	}

	private double setentaPorCientoSueldoMensualCliente() {
		return this.getCliente().getSueldoNetoMensual() * 0.7;
	}

	private boolean sueldoAnualSupera_(Float valorPonderable) {
		return this.getCliente().getSueldoNetoAnual() >= valorPonderable;
	}

}
