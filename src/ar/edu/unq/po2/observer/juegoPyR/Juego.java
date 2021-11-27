package ar.edu.unq.po2.observer.juegoPyR;

import java.util.HashSet;
import java.util.Set;

public class Juego implements IJuego{
	/*
	 * Se contempla una única partida en curso
	 * */

	private Set<IJugador> jugadores;
	private ProveedorDeCuestionarios proveedorCuestionarios;
	private Boolean estado;
	
	public Juego(ProveedorDeCuestionarios provCuestionarios) {
		this.jugadores = new HashSet<IJugador>();
		this.proveedorCuestionarios = provCuestionarios;
		this.estado = false;
	}

	@Override
	public void solicitaIngreso(IJugador jugador) {
		if (!this.iniciado() && this.tieneCupo()) {
			this.getJugadores().add(jugador);
		}
	}

	private Boolean tieneCupo() {
		return this.cantidadDeJugadores() < 5;
	}
	

	public Set<IJugador> getJugadores() {
		return this.jugadores;
	}

	private Boolean iniciado() {
		return this.estado;
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
		// por simplicidad solo toma el primero de la lista de cuestionario. Pero debería existir una lógica que tome cuestionarios de manera aleatoria
		return this.proveedorCuestionarios.getCuestionario();
	}

	@Override
	public void notificarJuegoIniciado() {
		this.iniciado(true);
		this.getJugadores().stream().forEach(jugador -> jugador.actualizarEstadoDeJuego(this));
	}

	private void iniciado(Boolean estado) {
		this.estado = estado;		
	}

	@Override
	public void notificarJuegoFinalizado() {
		//
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
