package ar.edu.unq.po2.observer.juegoPyR;

public interface IJuego {
	
	void solicitaIngreso(IJugador jugador);
	
	void notificarListoParaJugar();
	
	void notificarJuegoIniciado();
	
	void notificarJuegoFinalizado();
	
	void recibirRespuesta(String pregunta, String respuesta, IJugador jugador);

}
