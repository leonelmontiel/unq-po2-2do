package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EjercitoTest extends PelotonTest{

	protected Peloton ingeniero = mock(Ingeniero.class); //Doc (Dummy)
	protected Peloton caballero = mock(Caballero.class); //Doc (Dummy)
	protected Peloton ejercito = mock(Ejercito.class); //Doc (Dummy)

	@BeforeEach
	void setUp() throws Exception {
		this.parteDelPeloton = new Ejercito();
	}
	
	void reclutarA3(Peloton ingeniero, Peloton caballero, Peloton ejercito) {
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
		this.reclutarA3(ingeniero, caballero, ejercito);
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
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getSoldados().contains(ingeniero);
		//Verify
		assertFalse(pelotonContieneAIngeniero);
	}

}
