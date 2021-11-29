package ar.edu.unq.po2.stateStrategy.reproductorMP3;

public class Reproduciendo extends EstadoReproductorMP3 {

	private static EstadoReproductorMP3 instance;
	
	private Reproduciendo() {}

	public static EstadoReproductorMP3 getInstance() {
		if(instance == null) {
			instance = new Reproduciendo();
		}
		return instance;
	}
	
	@Override
	protected void play(ReproductorMP3 reproductorMP3) {
		reproductorMP3.mostrarMensaje(ERROR_REPRODUCIENDO);
	}

	@Override
	protected void pause(ReproductorMP3 reproductorMP3) {
		reproductorMP3.getCancionSeleccionada().pause();
		reproductorMP3.setEstado(Pausado.getInstance());
	}

	@Override
	protected void stop(ReproductorMP3 reproductorMP3) {
		reproductorMP3.getCancionSeleccionada().stop();
		reproductorMP3.setEstado(SeleccionDeCanciones.getInstance());
	}

}
