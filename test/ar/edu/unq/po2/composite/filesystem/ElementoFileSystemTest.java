package ar.edu.unq.po2.composite.filesystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

abstract class ElementoFileSystemTest {

	protected IFyleSystem elemento;

	@Test
	void testNombreEsElementoGenerico() {
		//Excersice
		String resultadoObtenido = this.elemento.getNombre();
		//Verify
		assertEquals("Elemento Gen�rico", resultadoObtenido);
	}

	@Test
	void testTama�oTotalEs50Bytes() {
		// Excersice
		int resultadoObtenido = this.elemento.totalSize();
		//Verify
		assertEquals(50, resultadoObtenido);
	}

}
