package ar.edu.unq.po2.stateStrategy.videoJuego;

public class EsperandoInicio extends EstadoMaquina {
	
	private static EsperandoInicio estado;

	private EsperandoInicio() {}
	
	public static EstadoMaquina getInstance() {
		if(estado == null) {
			estado = new EsperandoInicio();
		}
		return estado;
	}

	@Override
	protected void presionarBotonInicio(Maquina maquina) {
		Integer jugadores = Integer.min(maquina.getFichasIngresadas(), 2);
		maquina.setCantidadJugadores(jugadores);
		maquina.decrementarFichas(jugadores);
		maquina.setEstado(JuegoIniciado.getInstance());
	}

	@Override
	protected Boolean juegoIniciado(Maquina maquina) {
		return false;
	}

	@Override
	protected void ingresarFicha(Maquina maquina) {
		maquina.incrementarFichas();
	}

	@Override
	protected void finalizarJuego(Maquina maquina) {
		//no hace nada porque no hay un juego que finalizar
	}

}
