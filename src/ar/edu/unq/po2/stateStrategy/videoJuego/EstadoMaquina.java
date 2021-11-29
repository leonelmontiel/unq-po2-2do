package ar.edu.unq.po2.stateStrategy.videoJuego;

public abstract class EstadoMaquina {
	
	/*
	 * De ella derivan subclases que sabrán implementar a su manera el protocolo
	 */

	protected static final String MENSAJE_INGRESE_FICHA = "Ingrese una ficha";
	
	protected abstract void presionarBotonInicio(Maquina maquina);

	protected abstract Boolean juegoIniciado(Maquina maquina);

	protected abstract void ingresarFicha(Maquina maquina);

	protected abstract void finalizarJuego(Maquina maquina);

}
