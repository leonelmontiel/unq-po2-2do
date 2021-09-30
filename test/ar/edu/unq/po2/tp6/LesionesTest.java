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
		String nivel = LesionesDermatologicas.ROJO.nivelRiesgo();
		assertEquals("4", nivel);
	}
	
	@Test
	void testNivelRiesgoGRISEs1() {
		String nivel = LesionesDermatologicas.GRIS.nivelRiesgo();
		assertEquals("1", nivel);
	}
	
	@Test
	void testNivelRiesgoAMARILLOEs2() {
		String nivel = LesionesDermatologicas.AMARILLO.nivelRiesgo();
		assertEquals("2", nivel);
	}
	
	@Test
	void testNivelRiesgoMIELEs3() {
		String nivel = LesionesDermatologicas.MIEL.nivelRiesgo();
		assertEquals("3", nivel);
	}

}
