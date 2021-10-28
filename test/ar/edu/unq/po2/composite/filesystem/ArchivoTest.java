package ar.edu.unq.po2.composite.filesystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest extends ElementoFileSystemTest{

	@BeforeEach
	void setUp() throws Exception {
		this.elemento = new Archivo("Elemento Gen�rico", 50);
	}
	
	@Test
	void test�ltimoElementoEs�lMismo() {
		assertEquals(this.elemento, this.elemento.oldestElement());
	}

}