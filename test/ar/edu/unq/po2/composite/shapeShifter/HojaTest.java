package ar.edu.unq.po2.composite.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HojaTest {

	private Hoja hojaUno;
	private Hoja hojaDos;
	private ShapeShifter nodoUno;

	@BeforeEach
	void setUp() throws Exception {
		this.hojaUno = new Hoja(1);
		this.hojaDos = new Hoja(2);
		this.nodoUno = mock(Nodo.class);
		List<IShapeShifter> composicionPrueba = Arrays.asList(this.hojaUno, this.hojaDos);
		
		//Config Mocks
		when((this.nodoUno).getElementos()).thenReturn(composicionPrueba);
	}

	@Test
	void testHojaUnoFormaUnaComposiciónConHojaDos() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.hojaUno, this.hojaDos);
		//Excercise
		IShapeShifter composicion = this.hojaUno.compose(this.hojaDos);
		//Verify
		assertEquals(composicionEsperada, ((ShapeShifter) composicion).getElementos());
	}
	
	@Test
	void testHojaNoPuedeContenerElementos() {
		assertFalse(this.hojaUno.contiene(hojaDos));
	}
	
	@Test
	void testHojaUnoFormaUnaComposiciónConNodo() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.hojaUno, this.nodoUno);
		//Excercise
		IShapeShifter composicion = this.hojaUno.compose(this.nodoUno);
		//Verify
		assertEquals(composicionEsperada, ((ShapeShifter) composicion).getElementos());
	}
	
	@Test
	void testHojaProfundidadEsCero() {
		//Excercise
		int profundidadObtenida = this.hojaUno.deepest();
		//Verify
		assertEquals(0, profundidadObtenida);
	}
	
	@Test
	void testHojaUnoFlatEsElMismoShapeShifter() {
		//Excercise
		IShapeShifter shapeAchatado = this.hojaUno.flat();
		//Verify
		assertEquals(this.hojaUno, shapeAchatado);
	}
	
	@Test
	void testHojaUnoGetValue() {
		//Excercise
		int value = this.hojaUno.getValue();
		//Verify
		assertEquals(1, value);
	}
	
	@Test
	void testHojaUnoListaConSuValor() {
		//SetUp
		List<Integer> listaEsperada = Arrays.asList(1);
		//Excercise
		List<Integer> listaConValor = this.hojaUno.values();
		//Verify
		assertEquals(listaEsperada, listaConValor);
	}

}
