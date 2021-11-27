package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Set;

public class Juego implements IJuego{
	/*
	 * Se contempla una �nica partida en curso
	 * */

	private Set<IJugador> jugadores;
	private ProveedorDeCuestionarios proveedorCuestionarios;

	@Override
	public void solicitaIngreso(IJugador jugador) {
		if (!this.iniciado()) {
			this.getJugadores().add(jugador);
		}
	}

	public Set<IJugador> getJugadores() {
		return this.jugadores;
	}

	private Boolean iniciado() {
		return this.cantidadDeJugadores() == 5;
	}

	private int cantidadDeJugadores() {
		return this.getJugadores().size();
	}

	@Override
	public void notificarListoParaJugar() {
		Set<String> preguntas = this.getPreguntasPartida();
		this.getJugadores().stream().forEach(jugador -> jugador.recibirPreguntas(this, preguntas));
	}

	private Set<String> getPreguntasPartida() {
		return getSiguienteCuestionario().getPreguntas();
	}

	private Cuestionario getSiguienteCuestionario() {
		// por simplicidad solo toma el primero de la lista de cuestionario. Pero deber�a existir una l�gica que tome cuestionarios de manera aleatoria
		return this.proveedorCuestionarios.getCuestionario();
	}

	@Override
	public void notificarJuegoIniciado() {
		
	}

	@Override
	public void notificarJuegoFinalizado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) {
		// TODO Auto-generated method stub
		
	}

	void setJugadores(Set<IJugador> jugadores) {
		this.jugadores = jugadores;		
	}

	void setProveedorCuestionarios(ProveedorDeCuestionarios provCuestionarios) {
		this.proveedorCuestionarios = provCuestionarios;
	}

}
