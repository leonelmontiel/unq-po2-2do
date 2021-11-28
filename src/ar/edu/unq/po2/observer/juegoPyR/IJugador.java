package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Set;

public interface IJugador {

	void recibirPreguntas(IJuego juego, Set<String> preguntas);

	void actualizarEstadoDeJuego(IJuego juego);

	void accionNoPermitida(); //este método debería imprimir en consola

	void recibirNotificacionRC();

	String getNombre();

	void recibirNotificacionJugadorRC(String nombreJugador, String pregunta);

	void recibirNotificacionRInc();

	void recibirNotificacionGanador(String nombre);

}
