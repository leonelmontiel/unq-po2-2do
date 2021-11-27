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

	@BeforeEach
	void setUp() throws Exception {
		this.juego = new Juego();
		this.jugador = mock(IJugador.class);
		this.jugadorDos = mock(IJugador.class);
		this.cuestionario = mock(Cuestionario.class);
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
		ProveedorDeCuestionarios provCuestionarios = mock(ProveedorDeCuestionarios.class);
		@SuppressWarnings("unchecked")
		Set<String> preguntasDummy = mock(Set.class);
		when(this.cuestionario.getPreguntas()).thenReturn(preguntasDummy);
		when(provCuestionarios.getCuestionario()).thenReturn(this.cuestionario);
		this.juego.setProveedorCuestionarios(provCuestionarios);
		Set<IJugador> jugadores = new HashSet<IJugador>();
		jugadores.add(this.jugador);
		jugadores.add(this.jugadorDos);
		this.juego.setJugadores(jugadores);
		//exercise
		//Envía la notificación de manera arbitraria (sin contar con la cantidad de jugadores necesarios) para probar la funcionalidad
	 	this.juego.notificarListoParaJugar();	 	
		//verify
	 	verify(this.jugador).recibirPreguntas(this.juego, preguntasDummy);
	 	verify(this.jugadorDos).recibirPreguntas(this.juego, preguntasDummy);
	}

}
