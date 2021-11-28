package ar.edu.unq.po2.observer.juegoPyR;

public interface IJuego {
	
	void solicitaIngreso(IJugador jugador);
	
	void notificarListoParaJugar();
	
	void notificarJuegoIniciado();
	
	void recibirRespuesta(String pregunta, String respuesta, IJugador jugador);

	void notificarGanadorPartida();
	
	void notificarRCATodos(IJugador jugador, String pregunta);
}
