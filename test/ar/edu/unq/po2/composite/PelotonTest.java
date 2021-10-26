package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

abstract class PelotonTest {
	protected Peloton parteDelPeloton; //SUT
	protected Peloton ingeniero = mock(Ingeniero.class); //Doc (Dummy)

	@Test
	void testUbicacionInicialEs0Pasos() {
		//SetUp
		int ubicacionInicial = 0;
		assertEquals(ubicacionInicial, this.parteDelPeloton.getUbicacion());
	}
	
	@Test
	void testReclutarIngeniero() {
		//Excercise
		this.parteDelPeloton.reclutar(ingeniero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getLuchadores().contains(ingeniero);
		//Verify
		assertTrue(pelotonContieneAIngeniero);
	}
	
	@Test
	void testDesterrarDelPelotonAIngeniero() {
		//Excercise
		this.testReclutarIngeniero();
		this.parteDelPeloton.desterrar(ingeniero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.getLuchadores().contains(ingeniero);
		//Verify
		assertFalse(pelotonContieneAIngeniero);
	}

}
