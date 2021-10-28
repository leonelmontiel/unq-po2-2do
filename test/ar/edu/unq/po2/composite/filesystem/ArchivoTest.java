package ar.edu.unq.po2.composite.filesystem;

import org.junit.jupiter.api.BeforeEach;

class ArchivoTest extends ElementoFileSystemTest{

	@BeforeEach
	void setUp() throws Exception {
		this.elemento = new Archivo("Elemento Genérico", 50);
	}
	

}
