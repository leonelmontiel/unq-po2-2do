package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTest {

	private Inmueble inmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble("Mansion", "Calle Falsa", 5500000f);
	}

	@Test
	void testGetDescripcion() {
		assertEquals("Mansion", this.inmueble.getDescripcion());
	}

	@Test
	void testGetDireccion() {
		assertEquals("Calle Falsa", this.inmueble.getDireccion());
	}
	
	@Test
	void testGetValorFiscal() {
		assertEquals(5500000f, this.inmueble.getValorFiscal());
	}
}
