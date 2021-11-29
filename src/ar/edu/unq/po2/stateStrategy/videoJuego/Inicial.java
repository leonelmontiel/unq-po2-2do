package ar.edu.unq.po2.stateStrategy.videoJuego;

public class Inicial extends EstadoMaquina {

	private static Inicial estado;

	private Inicial() {}
	
	public static EstadoMaquina getInstance() {
		if(estado == null) {
			estado = new Inicial();
		}
		return estado;
	}
	
	@Override
	protected void ingresarFicha(Maquina maquina) {
		maquina.incrementarFichas();
		maquina.setEstado(EsperandoInicio.getInstance());
	}

	@Override
	protected void presionarBotonInicio(Maquina maquina) {
		maquina.notificarAlJugador(MENSAJE_INGRESE_FICHA);
	}

	@Override
	protected Boolean juegoIniciado(Maquina maquina) {
		return false;
	}

	@Override
	protected void finalizarJuego(Maquina maquina) {
		//no hace nada porque no hay un juego que finalizar
	}

}
