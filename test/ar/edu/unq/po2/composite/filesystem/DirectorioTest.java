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
	private IFileSystem archivo = mock(Archivo.class); //Doc
	private IFileSystem directorioAux; //Doc

	@BeforeEach
	void setUp() throws Exception {
		this.directorio = new Directorio("RHCP");
		this.directorioAux = new Directorio("Stadium Arcadium");
		
		//Config mocks
		when(this.archivo.totalSize()).thenReturn(50);
		
		((Directorio) this.directorioAux).agregarElemento(archivo);
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
		((Directorio) this.directorio).agregarElemento(archivo);
		List<IFileSystem> listaObtenida = ((Directorio) this.directorio).getContenido();
		//Verify
		assertFalse(listaObtenida.isEmpty());
	}
	
	@Test
	void testContieneAlArchivo() {
		//Excercise
		((Directorio) this.directorio).agregarElemento(archivo);
		boolean contieneAlArchivo = ((Directorio) this.directorio).contains(archivo);
		//Verify
		assertTrue(contieneAlArchivo);
	}
	
	@Test
	void testTamañoTotalEs100BytesPorContenerArchivoYDirectorioConArchivo() {
		//SetUp
		List<IFileSystem> listaConArchivo = Arrays.asList(archivo);
		// Excersice
		((Directorio) this.directorio).agregarElemento(archivo);
		((Directorio) this.directorio).agregarElemento(directorioAux);
		int resultadoObtenido = this.directorio.totalSize();
		//Verify
		assertEquals(listaConArchivo, ((Directorio) this.directorioAux).getContenido());
		assertEquals(100, resultadoObtenido);
		verify(this.archivo, times(2)).totalSize();
//		verify(this.directorioAux, times(1)).totalSize();
	}

}
