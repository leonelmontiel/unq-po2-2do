package ar.edu.unq.po2.tp7;

public class SolicitudPersonal extends SolicitudCredito {

	public SolicitudPersonal(Cliente cliente, Float monto, Integer plazo) {
		super(cliente, monto, plazo);
	}

	@Override
	public Boolean esAceptable() {
		return sueldoNetoAnualClienteSupera(15000f) && !this.valorCuotaSuperaPorcentajeRequeridoDeSueldo(70.0);
	}
	
	public boolean sueldoNetoAnualClienteSupera(Float unMinimoASuperar) {
		return this.getCliente().getSueldoNetoAnual() > unMinimoASuperar;
	}

}
