package ar.edu.unq.po2.observer.encuentrosDeportivos;

public interface ServidorObservado {
	
	void suscribirA(Observador observador, AspectoDeInteres aspecto);
	
	void desuscribirA(Observador observador, AspectoDeInteres aspecto);
	
	void notificarPartido(Partido partido);
}
