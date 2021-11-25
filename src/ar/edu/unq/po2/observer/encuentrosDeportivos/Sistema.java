package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.Map;
import java.util.Set;

public class Sistema implements ServidorObservado{

	private Map<AspectoDeInteres, Set<Observador>> observadores;

	public Sistema( Map<AspectoDeInteres, Set<Observador>> asociacion) {
		/*
		 * Un sistema siempre se inicializa con el aspecto de inter�s que conoce. No va a existir un sistema que se inicialice vac�o.
		 */
		this.observadores = asociacion;
	}

	@Override
	public void suscribirA(Observador observador, AspectoDeInteres aspecto) {
		this.getObservadores().get(aspecto).add(observador);		
	}

	public Map<AspectoDeInteres, Set<Observador>> getObservadores() {
		return this.observadores;
	}

	@Override
	public void desuscribirA(Observador observador, AspectoDeInteres aspecto) {
		this.getObservadores().get(aspecto).remove(observador);		
	}

	@Override
	public void notificarPartido(Partido partido) {
		this.getObservadores().get(partido.getDeporte()).stream().forEach(obs -> obs.recibirPartido(partido));
	}

}