package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.Map;
import java.util.Set;

public class Sistema implements ServidorObservado{

	private Map<AspectoDeInteres, Set<Observador>> observadores;

	public Sistema( Map<AspectoDeInteres, Set<Observador>> asociacion) {
		/*
		 * Un sistema siempre se inicializa con el aspecto de interés que conoce. No va a existir un sistema que se inicialice vacío.
		 */
		this.observadores = asociacion;
	}

	@Override
	public void suscribirA(Observador observador, AspectoDeInteres aspecto) {
		this.getObservadores().get(aspecto).add(observador);		
	}

	private Map<AspectoDeInteres, Set<Observador>> getObservadores() {
		return this.observadores;
	}

	@Override
	public void desuscribirA(Observador observador, AspectoDeInteres aspecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarPartido(Partido partido) {
		// TODO Auto-generated method stub
		
	}

}
