package ar.edu.unq.po2.stateStrategy.reproductorMP3;

public class SeleccionDeCanciones extends EstadoReproductorMP3 {

	private static EstadoReproductorMP3 instance;
	
	private SeleccionDeCanciones() {}

	public static EstadoReproductorMP3 getInstance() {
		if(instance == null) {
			instance = new SeleccionDeCanciones();
		}
		return instance;
	}

	@Override
	protected void play(ReproductorMP3 reproductorMP3) {
		reproductorMP3.getCancionSeleccionada().play();
		reproductorMP3.setEstado(Reproduciendo.getInstance());
	}

	@Override
	protected void pause(ReproductorMP3 reproductorMP3) {
		reproductorMP3.mostrarMensaje(ERROR_NO_REPRODUCIENDO);
	}

	@Override
	protected void stop(ReproductorMP3 reproductorMP3) {
		// no hace nada como se pide en el enunciado
		
	}

}
