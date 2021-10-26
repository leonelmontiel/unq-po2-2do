package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngenieroTest {

	private Ingeniero ingeniero;

	@BeforeEach
	void setUp() throws Exception {
		// comienza con 10 lajas en su bolsa
		this.ingeniero = new Ingeniero(10);
	}

	@Test
	void testCaminarDejandoLajasHaciendo5Pasos() {
		System.out.println("\n" + "testCaminarDejandoLajasHaciendo5Pasos(): ");
		Integer destino = 5; // representa los pasos hasta un determinado destino
		this.ingeniero.caminarHasta(destino);
		assertTrue(this.ingeniero.getLajas() == 5);
	}
	
	@Test
	void testCaminarDejandoLas10LajasHaciendo12Pasos() {
		System.out.println("\n" + "testCaminarDejandoLas10LajasHaciendo12Pasos(): ");
		Integer destino = 12; // representa los pasos hasta un determinado destino
		this.ingeniero.caminarHasta(destino);
		assertTrue(this.ingeniero.getLajas() == 0);
	}

}
