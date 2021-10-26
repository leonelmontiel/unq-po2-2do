package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngenieroTest {

	private Ingeniero ingeniero;

	@BeforeEach
	void setUp() throws Exception {
		// comienza con 20 lajas en su bolsa
		this.ingeniero = new Ingeniero(20);
	}

	@Test
	void caminarDejandoLajas20Lajas() {
		Integer destino = 5; // representa los pasos hasta un determinado destino
		this.ingeniero.caminarHasta(destino);
		assertTrue(this.ingeniero.getLajas() == 15);
	}

}
