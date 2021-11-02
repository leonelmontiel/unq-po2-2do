package ar.edu.unq.po2.composite.filesystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectorioTest {

	private IFileSystem directorio; //SUT
	private IFileSystem archivoUno = mock(Archivo.class); //Doc
	private IFileSystem archivoDos = mock(Archivo.class); //Doc
	private IFileSystem directorioAux; //Doc
	
	private IFileSystem archivoRealUno;
	private IFileSystem archivoRealDos;

	@BeforeEach
	void setUp() throws Exception {
		this.directorio = new Directorio("RHCP", LocalDate.of(2021, 7, 29));
		this.directorioAux = new Directorio("Stadium Arcadium", LocalDate.of(2021, 2, 20));
		
		this.archivoRealUno = new Archivo("Snow", 50, LocalDate.of(2021, 1, 5));
		this.archivoRealDos = new Archivo("Wet Sand", 100, LocalDate.of(2021, 11, 10));
		
		//Config mocks
		when(this.archivoUno.totalSize()).thenReturn(50);
		when(((ElementoFileSystem) this.archivoUno).getFechaCreacion()).thenReturn(LocalDate.of(2019, 2, 25));
//		when(((ElementoFileSystem) this.archivoUno).estructuraPrint(" ")).thenReturn(" -Snow");
		
		when(this.archivoDos.totalSize()).thenReturn(100);
		when(((ElementoFileSystem) this.archivoDos).getFechaCreacion()).thenReturn(LocalDate.of(2021, 2, 25));	
//		when(((ElementoFileSystem) this.archivoDos).estructuraPrint(" ")).thenReturn(" -Wet Sand");
	}

	@Test
	void testNombreEsRHCP() {
		//Excercise
		String resultadoObtenido = ((ElementoFileSystem) this.directorio).getNombre();
		//Verify
		assertEquals("RHCP", resultadoObtenido);
	}
	
	@Test
	void testFechaDeCreación() {
		//Excercise
		LocalDate fechaEsperada = LocalDate.of(2021, 7, 29);
		LocalDate fechaObtenida = ((Directorio) this.directorio).getFechaCreacion();
		//Verify
		assertEquals(fechaEsperada, fechaObtenida);
		
	}
	
	@Test
	void testGetContenidoVacío() {
		//Excercise
		List<IFileSystem> listaObtenida = ((Directorio) this.directorio).getContenido();
		//Verify
		assertTrue(listaObtenida.isEmpty());
	}
	
	@Test
	void testGetContenidoNoEsVacío() {
		//Excercise
		((Directorio) this.directorio).agregarElemento(archivoUno);
		List<IFileSystem> listaObtenida = ((Directorio) this.directorio).getContenido();
		//Verify
		assertFalse(listaObtenida.isEmpty());
	}
	
	@Test
	void testContieneAlArchivo() {
		//Excercise
		((Directorio) this.directorio).agregarElemento(archivoUno);
		boolean contieneAlArchivo = ((Directorio) this.directorio).contains(archivoUno);
		//Verify
		assertTrue(contieneAlArchivo);
	}
	
	@Test
	void testTamañoTotalEs150BytesPorContenerArchivoYDirectorioConArchivo() {
		//SetUp
		List<IFileSystem> listaConArchivo = Arrays.asList(archivoDos);
		// Excersice
		((Directorio) this.directorioAux).agregarElemento(archivoDos);
		((Directorio) this.directorio).agregarElemento(archivoUno);
		((Directorio) this.directorio).agregarElemento(directorioAux);
		int resultadoObtenido = this.directorio.totalSize();
		//Verify
		assertEquals(listaConArchivo, ((Directorio) this.directorioAux).getContenido());
		assertEquals(150, resultadoObtenido);
		verify(this.archivoUno, times(1)).totalSize();
		verify(this.archivoDos, times(1)).totalSize();
//		verify(this.directorioAux, times(1)).totalSize();
	}
	
	@Test
	void testElementoMásAntiguoEsArchivoRealUno() {
		/*
		 * usando archivos como mocks me tira este error aunque haya configurado lo que devuelve getFechaCreacion:
		 * org.opentest4j.AssertionFailedError: expected: <Mock for Archivo, hashCode: 740827140> but was: <null>
		 * 		
		*/
		
		//SetUp
		Archivo archivoRealUno = new Archivo("Snow", 50, LocalDate.of(2021, 1, 5));
		Archivo archivoRealDos = new Archivo("Wet Sand", 100, LocalDate.of(2021, 11, 10));
		((Directorio) this.directorio).agregarElemento(archivoRealUno);
		((Directorio) this.directorio).agregarElemento(archivoRealDos);
		((Directorio) this.directorio).agregarElemento(this.directorioAux); //2021, 2, 20
		
		//Excercise
		IFileSystem elemMásAntiguo = this.directorio.oldestElement();
		//Verify
		assertEquals(archivoRealUno, elemMásAntiguo);
		//verify(this.archivoUno, times(1)).oldestElement();
	}
	
	@Test
	void testElementoMásNuevoEsArchivoRealDos() {
		/*
		 * usando archivos como mocks me tira este error aunque haya configurado lo que devuelve getFechaCreacion:
		 * org.opentest4j.AssertionFailedError: expected: <Mock for Archivo, hashCode: 740827140> but was: <null>
		 * 		
		*/
		
		//SetUp
		
		((Directorio) this.directorio).agregarElemento(archivoRealUno);
		((Directorio) this.directorio).agregarElemento(archivoRealDos);
		((Directorio) this.directorio).agregarElemento(this.directorioAux); //2021, 2, 20
		
		//Excercise
		IFileSystem elemMásNuevo = this.directorio.lastModified();
		//Verify
		assertEquals(archivoRealDos, elemMásNuevo);
	}
	
	@Test
	void testPrintEstructureDirectorio() {
		// hago este test con archivos reales porque con mocks no funciona como quisiera
		// excercise
		((Directorio) this.directorioAux).agregarElemento(this.archivoRealUno);
		((Directorio) this.directorioAux).agregarElemento(this.archivoRealDos);
		
		((Directorio) this.directorio).agregarElemento(this.archivoRealUno);
		((Directorio) this.directorio).agregarElemento(this.archivoRealDos);
		((Directorio) this.directorio).agregarElemento(this.directorioAux);
		
		((Directorio) this.directorio).agregarElemento(this.archivoRealUno);
		
		this.directorio.printStructure();
		
	}

}
