package ar.edu.unq.po2.observer.juegoPyR;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Juego implements IJuego{
	/*
	 * Se contempla una única partida en curso
	 * */

	private Set<IJugador> jugadores;
	private ProveedorDeCuestionarios proveedorCuestionarios;
	private Boolean estado;
	private Cuestionario cuestionarioActual;
	private Puntaje puntajes;
	
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
		Cuestionario cuestionario = this.proveedorCuestionarios.getCuestionario();
		this.setCuestionarioActual(cuestionario);
		// por simplicidad solo toma el primero de la lista de cuestionario. Pero debería existir una lógica que tome cuestionarios de manera aleatoria
		return cuestionario;
	}

	void setCuestionarioActual(Cuestionario cuestionario) {
		this.cuestionarioActual	= cuestionario;	
	}

	@Override
	public void notificarJuegoIniciado() {
		this.iniciado(true);
		this.getJugadores().stream().forEach(jugador -> jugador.actualizarEstadoDeJuego(this));
	}

	void iniciado(Boolean estado) {
		this.estado = estado;		
	}

	@Override
	public void notificarJuegoFinalizado() {
		
	}

	@Override
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) {
		if (!this.iniciado()) {
			jugador.accionNoPermitida();
		} else {
			this.evaluarRespuesta(pregunta, respuesta, jugador);
		}
	}

	private void evaluarRespuesta(String pregunta, String respuesta, IJugador jugador) {
		if (this.cuestionarioActual.evaluarRespuesta(pregunta, respuesta)) {
			this.getPuntajes().contabilizarRC(jugador);
			jugador.recibirNotificacionRC();
			this.notificarRCATodos(jugador, pregunta);
		} else {
			jugador.recibirNotificacionRInc();
		}
		
	}

	Puntaje getPuntajes() {
		return this.puntajes;
	}

	private void notificarRCATodos(IJugador jugador, String pregunta) {
		Stream<IJugador> jugadoresNoGanadores = this.getJugadores().stream().filter(jug -> !jug.equals(jugador));
		jugadoresNoGanadores.forEach(jug -> jug.recibirNotificacionJugadorRC(jugador.getNombre(), pregunta));		
	}

	void setJugadores(Set<IJugador> jugadores) {
		this.jugadores = jugadores;		
	}

	void setProveedorCuestionarios(ProveedorDeCuestionarios provCuestionarios) {
		this.proveedorCuestionarios = provCuestionarios;
	}

	void setPuntajes(Puntaje puntaje) {
		this.puntajes = puntaje;		
	}

}
