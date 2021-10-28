package ar.edu.unq.po2.composite.filesystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectorioTest {

	private IFileSystem directorio; //SUT
	private IFileSystem archivo = mock(Archivo.class);
	private IFileSystem directorioAux = mock(Directorio.class);

	@BeforeEach
	void setUp() throws Exception {
		this.directorio = new Directorio("RHCP");
		
		//Config mocks
		when(this.archivo.totalSize()).thenReturn(50);
		when(this.directorioAux.totalSize()).thenReturn(50);
	}

	@Test
	void testNombreEsRHCP() {
		//Excercise
		String resultadoObtenido = this.directorio.getNombre();
		//Verify
		assertEquals("RHCP", resultadoObtenido);
	}
	
	@Test
	void testFechaDeCreaci�n() {
		//Excercise
		LocalDate fechaEsperada = LocalDate.now();
		LocalDate fechaObtenida = ((Directorio) this.directorio).getFechaCreacion();
		//Verify
		assertEquals(fechaEsperada, fechaObtenida);
		
	}
	
	@Test
	void testGetContenidoVac�o() {
		//Excercise
		List<IFileSystem> listaObtenida = ((Directorio) this.directorio).getContenido();
		//Verify
		assertTrue(listaObtenida.isEmpty());
	}
	
	@Test
	void testGetContenidoNoEsVac�o() {
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
	/*
	@Test
	void testTama�oTotalEs100BytesPorContenerArchivoYDirectorioConArchivo() {
		// Excersice
		int resultadoObtenido = this.directorio.totalSize();
		//Verify
		assertEquals(100, resultadoObtenido);
		verify(this.archivo, times(2)).totalSize();
		verify(this.directorioAux, times(1)).totalSize();
	}*/

}
