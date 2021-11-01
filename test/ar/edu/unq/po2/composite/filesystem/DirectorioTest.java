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

	@BeforeEach
	void setUp() throws Exception {
		this.directorio = new Directorio("RHCP");
		this.directorioAux = new Directorio("Stadium Arcadium");
		
		//Config mocks
		when(this.archivoUno.totalSize()).thenReturn(50);
		when(this.archivoDos.totalSize()).thenReturn(100);
		
		((Directorio) this.directorioAux).agregarElemento(archivoDos);
	}

	@Test
	void testNombreEsRHCP() {
		//Excercise
		String resultadoObtenido = this.directorio.getNombre();
		//Verify
		assertEquals("RHCP", resultadoObtenido);
	}
	
	@Test
	void testFechaDeCreación() {
		//Excercise
		LocalDate fechaEsperada = LocalDate.now();
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
	void testTamañoTotalEs1500BytesPorContenerArchivoYDirectorioConArchivo() {
		//SetUp
		List<IFileSystem> listaConArchivo = Arrays.asList(archivoDos);
		// Excersice
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
	void testElementoMásAntiguoEsArchivoUno() {
		
	}

}
