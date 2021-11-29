package ar.edu.unq.po2.stateStrategy.reproductorMP3;

public abstract class EstadoReproductorMP3 {
	
	/*
	 * De ella derivan subclases que sabrán implementar a su manera el protocolo
	 */
	
	protected static final String ERROR_NO_REPRODUCIENDO = "El reproductor no esta reproduciendo";
	protected static final String ERROR_REPRODUCIENDO = "El reproductor se encuentra reproduciendo";
	
	protected abstract void play(ReproductorMP3 reproductorMP3);

	protected abstract void pause(ReproductorMP3 reproductorMP3);

	protected abstract void stop(ReproductorMP3 reproductorMP3);

