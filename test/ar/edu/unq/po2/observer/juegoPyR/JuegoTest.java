package ar.edu.unq.po2.observer.juegoPyR;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {

	private Juego juego;
	private IJugador jugador;

	@BeforeEach
	void setUp() throws Exception {
		this.juego = new Juego();
		this.jugador = mock(IJugador.class);
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

}
