package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTest {

	private Inmueble inmueble;

	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble("Mansión", "Calle Falsa", 5500000f);
	}

	@Test
	void testDescripcion() {
		assertEquals("Mansión", inmueble.getDescripcion());
	}
	
	@Test
	void testDireccion() {
		assertEquals("Calle Falsa", inmueble.getDireccion());
	}
	
	@Test
	void testValorFiscal5500000f() {
		assertEquals(5500000f, inmueble.getValorFiscal());
	}

}
