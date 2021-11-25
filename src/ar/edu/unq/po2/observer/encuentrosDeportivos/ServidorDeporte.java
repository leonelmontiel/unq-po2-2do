package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServidorDeporte implements ServidorObservado, Observador {

	private Map<AspectoDeInteres, Set<Observador>> observadores;

	public ServidorDeporte(Map<AspectoDeInteres, Set<Observador>> asociacion) {
		this.setObservadores(asociacion);
	}

	private void setObservadores(Map<AspectoDeInteres, Set<Observador>> asociacion) {
		this.observadores = asociacion;		
	}

	@Override
	public void recibirPartido(Partido partido) {
		this.notificarPartido(partido);
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
		Set<Observador> resultado = new HashSet<Observador>();
		resultado.addAll(this.getObservadores().get(partido.getDeporte()));
		
		partido.getContrincantes().stream().forEach(cont -> resultado.addAll(this.getObservadores().get(cont)));
		resultado.stream().forEach(obs -> obs.recibirPartido(partido));		
	}

}
