package ar.edu.unq.po2.composite.filesystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest extends ElementoFileSystemTest{

	@BeforeEach
	void setUp() throws Exception {
		this.elemento = new Archivo("Elemento GenÈrico", 50);
	}
	
	@Test
	void estElementoM·sNuevoEs…lMismo() {
		assertEquals(this.elemento, this.elemento.oldestElement());
	}
	
	@Test
	void testElementoM·sAntiguoEs…lMismo() {
		assertEquals(this.elemento, this.elemento.lastModified());
	}
	
	

}
