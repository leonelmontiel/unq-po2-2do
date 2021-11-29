package ar.edu.unq.po2.stateStrategy.videoJuego;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaquinaTest {

	Maquina maquina;
	Pantalla pantalla;
	
	@BeforeEach
	void setUp() throws Exception {
	
		this.pantalla = mock(Pantalla.class);
		this.maquina = new Maquina(this.pantalla);
		
	}
	
	@Test
	void testUnaMaquinaNoTieneJuegoIniciado() {
		assertFalse(this.maquina.juegoIniciado());
	}

	@Test
	void testSePresionaElBotonInicioAlEncenderLaMaquina() {
		//exercise
		this.maquina.presionarBotonInicio();
	
		//verify
		verify(this.pantalla).mostrar("Ingrese una ficha");
	}

	@Test
	void testPideFinalizarJuegoAlEncenderLaMaquina() {
		//verificar estado previo al exercise
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());
		
		//exercise
		this.maquina.finalizarJuego();
	
		//verificar que no cambio luego del exercise
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());
	}

	@Test 
	void testSeIngresaUnaFichaPeroNoSePresionaElBoton() {
		//exercise
		this.maquina.ingresarFicha();
		
		//verify
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		assertEquals(1, this.maquina.getFichasIngresadas());
	}

	@Test
	void testPideFinalizarJuegoLuegoDeIngresarUnaFicha() {
		//setup
		this.maquina.ingresarFicha();
		
		//verificar estado previo al exercise
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		assertEquals(1, this.maquina.getFichasIngresadas());
		
		//exercise
		this.maquina.finalizarJuego();
	
		//verificar que no cambio luego del exercise
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		assertEquals(1, this.maquina.getFichasIngresadas());
	}
	
	@Test 
	void testSeIngresaUnaFichaYSePresionaElBoton() {
		//exercise
		this.maquina.ingresarFicha();
		this.maquina.presionarBotonInicio();
		
		//verify
		assertTrue(this.maquina.juegoIniciado());
		assertEquals(1, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());
	}

	@Test 
	void testSeIngresaUnaFichaEnMaquinaConJuegoIniciado() {
		//exercise
		this.maquina.ingresarFicha();
		this.maquina.presionarBotonInicio();
		this.maquina.ingresarFicha();
		
		//verify
		assertTrue(this.maquina.juegoIniciado());
		assertEquals(1, this.maquina.getCantidadJugadores());
		assertEquals(1, this.maquina.getFichasIngresadas());
	}

	@Test 
	void testSePresionaElBotonInicioEnMaquinaConJuegoIniciado() {
		//setup
		this.maquina.ingresarFicha();
		this.maquina.presionarBotonInicio();

		assertTrue(this.maquina.juegoIniciado());
		assertEquals(1, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());

		//exercise
		this.maquina.presionarBotonInicio();
		
		//verify
		assertTrue(this.maquina.juegoIniciado());
		assertEquals(1, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());
	}

	@Test
	void testMaquinaConDosFichasIniciaElJuegoParaDosJugadores() {
		//setup
		this.maquina.ingresarFicha();
		this.maquina.ingresarFicha();
		
		//exercise
		this.maquina.presionarBotonInicio();
		
		//verify
		assertTrue(this.maquina.juegoIniciado());
		assertEquals(2, this.maquina.getCantidadJugadores());
		assertEquals(0, this.maquina.getFichasIngresadas());
	}
	
	@Test
	void testMaquinaMasConTresFichasIniciaElJuegoParaDosJugadores() {
		//setup
		this.maquina.ingresarFicha();
		this.maquina.ingresarFicha();
		this.maquina.ingresarFicha();
		
		//exercise
		this.maquina.presionarBotonInicio();
		
		//verify
		assertTrue(this.maquina.juegoIniciado());
		assertEquals(2, this.maquina.getCantidadJugadores());
		assertEquals(1, this.maquina.getFichasIngresadas());
	}

	@Test
	void testMaquinaFinalizaElJuegoYNotificaAlJugador() {
		//setup
		this.maquina.ingresarFicha();
		this.maquina.presionarBotonInicio();
		
		//exercise
		this.maquina.finalizarJuego();
		
		//verify
		assertFalse(this.maquina.juegoIniciado());
		assertEquals(0, this.maquina.getCantidadJugadores());
		verify(this.pantalla).mostrar("Game Over");
	}
	
}
