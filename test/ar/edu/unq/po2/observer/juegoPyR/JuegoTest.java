package ar.edu.unq.po2.observer.juegoPyR;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {

	private Juego juego;
	private IJugador jugador;
	private IJugador jugadorDos;
	private Cuestionario cuestionario;
	private ProveedorDeCuestionarios provCuestionarios;
	private Puntaje puntaje;

	@BeforeEach
	void setUp() throws Exception {
		this.provCuestionarios = mock(ProveedorDeCuestionarios.class);
		this.jugador = mock(IJugador.class);
		this.jugadorDos = mock(IJugador.class);
		this.cuestionario = mock(Cuestionario.class);
		this.puntaje = mock(Puntaje.class);
		
		this.juego = new Juego(this.provCuestionarios, this.puntaje);
	}

	@Test
	void testSolicitaIngresoAPartidaOK() {
		//setUp
		Set<IJugador> jugadoresSpy = spy(new HashSet<IJugador>());
		this.juego.setJugadores(jugadoresSpy);
		//exercise
		this.juego.solicitaIngreso(this.jugador);
		//verify
		verify(jugadoresSpy).add(this.jugador);
	}
	
	@Test
	void testSolicitarIngresoAPartidaNoOK() {
		//setUp
		@SuppressWarnings("unchecked")
		Set<IJugador> jugadoresMock = mock(Set.class);
		this.juego.setJugadores(jugadoresMock);
		when(jugadoresMock.size()).thenReturn(5);
		//exercise
		this.juego.solicitaIngreso(this.jugador);
		//verify
		verify(jugadoresMock).size();
		verify(jugadoresMock, never()).add(this.jugador);
	}
	
	@Test
	void testNotificarListoParaJugar() {
		//setUp
		@SuppressWarnings("unchecked")
		Set<String> preguntasDummy = mock(Set.class);
		when(this.cuestionario.getPreguntas()).thenReturn(preguntasDummy);
		when(this.provCuestionarios.getCuestionario()).thenReturn(this.cuestionario);
		Set<IJugador> jugadores = new HashSet<IJugador>();
		jugadores.add(this.jugador);
		jugadores.add(this.jugadorDos);
		this.juego.setJugadores(jugadores);
		//exercise
		//Env?a la notificaci?n de manera arbitraria (sin contar con la cantidad de jugadores necesarios) para probar la funcionalidad
	 	this.juego.notificarListoParaJugar();	 	
		//verify
	 	verify(this.jugador).recibirPreguntas(this.juego, preguntasDummy);
	 	verify(this.jugadorDos).recibirPreguntas(this.juego, preguntasDummy);
	}
	
	@Test
	void testNotificarJuegoIniciado() {
		//setUp
		Set<IJugador> jugadores = new HashSet<IJugador>();
		jugadores.add(this.jugador);
		jugadores.add(this.jugadorDos);
		this.juego.setJugadores(jugadores);
		//exercise
		this.juego.notificarJuegoIniciado();
		//verify
		verify(this.jugador).actualizarEstadoDeJuego(this.juego);
		verify(this.jugadorDos).actualizarEstadoDeJuego(this.juego);
	}
	
	@Test
	void testRecibirRespuestaConJuegoNoIniciado() {
		this.juego.recibirRespuesta("pregunta", "respuesta", this.jugador);
		//verify
		verify(this.jugador).accionNoPermitida();
	}
	
	@Test
	void testRecibirRespuestaCorrectaConJuegoIniciado() {
		/*
		 * notifica al jugador que gan? la ronda
		 * contabiliza el puntaje del jugador
		 * notifica a todos el nombre del jugador y la pregunta
		 * 
		 */
		//setUp
		when(this.jugador.getNombre()).thenReturn("lalolanda");
		when(this.cuestionario.evaluarRespuesta("pregunta", "respuesta")).thenReturn(true);
		this.juego.iniciado(true);
		this.juego.setCuestionarioActual(this.cuestionario);
		
		Set<IJugador> jugadores = new HashSet<IJugador>();
		jugadores.add(this.jugador);
		jugadores.add(this.jugadorDos);
		this.juego.setJugadores(jugadores);
		
		//exercise
		this.juego.recibirRespuesta("pregunta", "respuesta", this.jugador);
		
		//verify
		verify(this.jugador).recibirNotificacionRC();
		verify(this.jugador, never()).accionNoPermitida();
		verify(this.jugadorDos).recibirNotificacionJugadorRC("lalolanda", "pregunta");
		verify(this.puntaje).contabilizarRC(this.jugador);
		verify(this.cuestionario).evaluarRespuesta("pregunta", "respuesta");
	}
	
	@Test
	void testRecibirRespuestaIncorrectaConJuegoIniciado() {
		//setUp
		when(this.cuestionario.evaluarRespuesta("pregunta", "respuesta")).thenReturn(false);
		this.juego.iniciado(true);
		this.juego.setCuestionarioActual(this.cuestionario);		
		//exercise
		this.juego.recibirRespuesta("pregunta", "respuesta", this.jugador);
		//verify
		verify(this.cuestionario, atLeast(1)).evaluarRespuesta("pregunta", "respuesta"); //como se usa un if, se eval?a por cada rama de condiciones (refactorizar)
		verify(this.cuestionario, never()).esUltimaPregunta("pregunta"); //nunca llega a evaluarse porque se utiliz? un circuito corto
		verify(this.jugador).recibirNotificacionRInc();
	}
	
	@Test
	void testUltimaPreguntaRespondidaCorrectamente() {
		//setUp
		when(this.jugador.getNombre()).thenReturn("lalolanda");
		when(this.cuestionario.evaluarRespuesta("pregunta", "respuesta")).thenReturn(true);
		when(this.cuestionario.esUltimaPregunta("pregunta")).thenReturn(true);
		when(this.cuestionario.getNombreGanador()).thenReturn("Max Power");
		this.juego.iniciado(true);
		this.juego.setCuestionarioActual(this.cuestionario);
		
		Set<IJugador> jugadores = new HashSet<IJugador>();
		jugadores.add(this.jugador);
		jugadores.add(this.jugadorDos);
		this.juego.setJugadores(jugadores);
		
		//exercise
		this.juego.recibirRespuesta("pregunta", "respuesta", this.jugador);
		
		//verify
		verify(this.jugador).recibirNotificacionGanador("Max Power");
		verify(this.jugador).recibirNotificacionRC();
		verify(this.jugador, never()).accionNoPermitida();
		verify(this.jugadorDos).recibirNotificacionJugadorRC("lalolanda", "pregunta");
		verify(this.jugadorDos).recibirNotificacionGanador("Max Power");
		verify(this.puntaje).contabilizarRC(this.jugador);
		verify(this.cuestionario, atLeast(1)).evaluarRespuesta("pregunta", "respuesta"); //como se usa un if, se eval?a por cada rama de condiciones (refactorizar)
		verify(this.cuestionario, atLeast(1)).esUltimaPregunta("pregunta");
		verify(this.cuestionario).getNombreGanador();
	}

}
