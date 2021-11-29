package ar.edu.unq.po2.stateStrategy.reproductorMP3;

public class Pausado extends EstadoReproductorMP3 {

	private static EstadoReproductorMP3 instance;
	
	private Pausado() {}

	public static EstadoReproductorMP3 getInstance() {
		if(instance == null) {
			instance = new Pausado();
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
		this.play(reproductorMP3);
	}

	@Override
	protected void stop(ReproductorMP3 reproductorMP3) {
		reproductorMP3.getCancionSeleccionada().stop();
		reproductorMP3.setEstado(SeleccionDeCanciones.getInstance());
	}

}
