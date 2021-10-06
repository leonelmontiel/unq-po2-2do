package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LesionesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testROJOAGRIS() {
		LesionesDermatologicas siguienteDe = LesionesDermatologicas.ROJO.siguiente();
		assertEquals(LesionesDermatologicas.GRIS, siguienteDe);
	}
	
	@Test
	void testGRISAAMARILLO() {
		LesionesDermatologicas siguienteDe = LesionesDermatologicas.GRIS.siguiente();
		assertEquals(LesionesDermatologicas.AMARILLO, siguienteDe);
	}
	
	@Test
	void tesAMARILLOAMIEL() {
		LesionesDermatologicas siguienteDe = LesionesDermatologicas.AMARILLO.siguiente();
		assertEquals(LesionesDermatologicas.MIEL, siguienteDe);
	}
	
	@Test
	void testMIELAROJO() {
		LesionesDermatologicas siguienteDe = LesionesDermatologicas.MIEL.siguiente();
		assertEquals(LesionesDermatologicas.ROJO, siguienteDe);
	}
	
	@Test
	void testNivelRiesgoROJOoEs4() {
		int nivel = LesionesDermatologicas.ROJO.nivelRiesgo();
		assertEquals(4, nivel);
	}
	
	@Test
	void testNivelRiesgoGRISEs1() {
		int nivel = LesionesDermatologicas.GRIS.nivelRiesgo();
		assertEquals(1, nivel);
	}
	
	@Test
	void testNivelRiesgoAMARILLOEs2() {
		int nivel = LesionesDermatologicas.AMARILLO.nivelRiesgo();
		assertEquals(2, nivel);
	}
	
	@Test
	void testNivelRiesgoMIELEs3() {
		int nivel = LesionesDermatologicas.MIEL.nivelRiesgo();
		assertEquals(3, nivel);
	}
	
	@Test
	void testDescROJOEsLetal() {
		String descr = LesionesDermatologicas.ROJO.descripcion();
		assertEquals("Letal", descr);
	}
	
	@Test
	void testDescGRISEsSuperficial() {
		String descr = LesionesDermatologicas.GRIS.descripcion();
		assertEquals("Superficial", descr);
	}
	
	@Test
	void testDescAMARILLOEsGrave() {
		String descr = LesionesDermatologicas.AMARILLO.descripcion();
		assertEquals("Grave", descr);
	}
	
	@Test
	void testDescMIELEsMuyGrave() {
		String descr = LesionesDermatologicas.MIEL.descripcion();
		assertEquals("Muy grave", descr);
	}

}
