package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContrincanteTest {

	private String nombreEsperado;
	private Contrincante contrincante;

	@BeforeEach
	void setUp() throws Exception {
		this.nombreEsperado = "futbol";
		this.contrincante = new Contrincante(this.nombreEsperado);
	}

	@Test
	void testGetNombre() {
		String nombreObtenido = this.contrincante.getNombre();
		//verify
		assertEquals(this.nombreEsperado, nombreObtenido);
	}

}
