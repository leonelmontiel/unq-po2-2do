package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Set;

public interface IJugador {

	void recibirPreguntas(Juego juego, Set<String> preguntasDummy);

	void actualizarEstadoDeJuego(Juego juego);

	void accionNoPermitida(); //este método debería imprimir en consola

	void recibirNotificacionRC();

	String getNombre();

	void recibirNotificacionJugadorRC(String nombreJugador, String pregunta);

	void recibirNotificacionRInc();

}
