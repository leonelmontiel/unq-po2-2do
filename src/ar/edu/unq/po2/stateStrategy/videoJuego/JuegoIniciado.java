package ar.edu.unq.po2.stateStrategy.videoJuego;

public class JuegoIniciado extends EstadoMaquina {
	
	private static final String MENSAJE_GAME_OVER = "Game Over";
	private static EstadoMaquina estado;

	private JuegoIniciado() {}
	
	public static EstadoMaquina getInstance() {
		if(estado == null) {
			estado = new JuegoIniciado();
		}
		return estado;
	}

	@Override
	protected void presionarBotonInicio(Maquina maquina) {
		// no hace nada porque el juego ya esta iniciado
	}

	@Override
	protected Boolean juegoIniciado(Maquina maquina) {
		return true;
	}

	@Override
	protected void ingresarFicha(Maquina maquina) {
		// se supone que la maquina puede seguir recibiendo fichas
		maquina.incrementarFichas();
	}

	@Override
	protected void finalizarJuego(Maquina maquina) {
		maquina.notificarAlJugador(MENSAJE_GAME_OVER);
		maquina.setEstado(Inicial.getInstance());
		maquina.setCantidadJugadores(0);
	}

}
