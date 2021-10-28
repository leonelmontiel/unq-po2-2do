package ar.edu.unq.po2.composite.juego;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EjercitoTest extends PelotonTest{

	protected Peloton ingeniero = mock(Ingeniero.class); //Doc (Dummy)
	protected Peloton caballero = mock(Caballero.class); //Doc (Dummy)
	protected Peloton ejercito;

	@BeforeEach
	void setUp() throws Exception {
		this.parteDelPeloton = new Ejercito();
		this.ejercito = new Ejercito();
	}
	
	void ejercitoReclutaAIngenieroYCaballero() {
		this.ejercito.reclutar(ingeniero);
		this.ejercito.reclutar(caballero);
	}
	
	void reclutarA3() {
		this.ejercitoReclutaAIngenieroYCaballero();
		this.parteDelPeloton.reclutar(ingeniero);
		this.parteDelPeloton.reclutar(caballero);
		this.parteDelPeloton.reclutar(ejercito);
	}

	@Test
	void testReclutarIngeniero() {
		//Excercise
		this.parteDelPeloton.reclutar(ingeniero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getSoldados().contains(ingeniero);
		//Verify
		assertTrue(pelotonContieneAIngeniero);
	}
	
	@Test
	void testReclutarIngenieroYCaballero() {
		//Excercise
		this.parteDelPeloton.reclutar(ingeniero);
		this.parteDelPeloton.reclutar(caballero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getSoldados().contains(ingeniero);
		boolean pelotonContieneACaballero = this.parteDelPeloton.getSoldados().contains(caballero);
		//Verify
		assertTrue(pelotonContieneAIngeniero);
		assertTrue(pelotonContieneACaballero);
	}
	
	@Test
	void testReclutarALas3Partes() {
		//Excercise
		this.reclutarA3();
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getSoldados().contains(ingeniero);
		boolean pelotonContieneACaballero = this.parteDelPeloton.getSoldados().contains(caballero);
		boolean pelotonContieneAEjercito = this.parteDelPeloton.getSoldados().contains(ejercito);
		//Verify
		assertTrue(pelotonContieneAIngeniero);
		assertTrue(pelotonContieneACaballero);
		assertTrue(pelotonContieneAEjercito);
	}
	
	
	@Test
	void testDesterrarDelPelotonAIngeniero() {
		//Excercise
		this.testReclutarIngeniero();
		this.parteDelPeloton.desterrar(ingeniero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.contains(ingeniero);
		//Verify
		assertFalse(pelotonContieneAIngeniero);
	}
	
	@Test
	void testTodosAvanzaronADestino() {
		this.reclutarA3();
		this.testAvanzarHaciaDestino();
		verify(this.ingeniero, times(2)).caminarHasta(destino); // debería enviarse el mensaje la primera vez directamente y la segunda desde el mock ejercito
		verify(this.caballero, times(2)).caminarHasta(destino); // debería enviarse el mensaje la primera vez directamente y la segunda desde el mock ejercito
	}

}
