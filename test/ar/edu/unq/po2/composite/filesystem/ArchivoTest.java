package ar.edu.unq.po2.composite.filesystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	
	private IFileSystem archivo; //SUT

	@BeforeEach
	void setUp() throws Exception {
		this.archivo = new Archivo("Snow.mp3", 50, LocalDate.of(2021, 5, 10));
	}
	
	@Test
	void testNombreEsSnow_mp3() {
		//Excercise
		String resultadoObtenido = ((ElementoFileSystem) this.archivo).getNombre();
		//Verify
		assertEquals("Snow.mp3", resultadoObtenido);
	}

	@Test
	void testTamañoTotalEs50Bytes() {
		// Excercise
		int resultadoObtenido = this.archivo.totalSize();
		//Verify
		assertEquals(50, resultadoObtenido);
	}
	
	@Test
	void estElementoMásAntiguoEsÉlMismo() {
		assertEquals(this.archivo, this.archivo.oldestElement());
	}
	
	@Test
	void testElementoMásNuevoEsÉlMismo() {
		assertEquals(this.archivo, this.archivo.lastModified());
	}
	
	@Test
	void testPrintStructure() {
		this.archivo.printStructure();
	}
	
	@Test
	void testFechaültimaModificación() {
		// Excercise
		LocalDate fechaEsperada = LocalDate.now();
		LocalDate fechaObtenida = ((Archivo) this.archivo).getUltimaModificacion();
		//Verify
		assertEquals(fechaEsperada, fechaObtenida);
	}

}
