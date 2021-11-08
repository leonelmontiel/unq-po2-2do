package ar.edu.unq.po2.composite.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodoTest {
	
	private Nodo nodo;
	private ShapeShifter hojaUno = mock(Hoja.class);
	private ShapeShifter hojaDos = mock(Hoja.class);

	@BeforeEach
	void setUp() throws Exception {
		this.nodo = new Nodo(this.hojaUno, this.hojaDos);
	}
	
	@Test
	void testNodoContieneElementos() {
		assertTrue(this.nodo.contiene(this.hojaUno));
		assertTrue(this.nodo.contiene(this.hojaDos));
	}
	
	@Test
	void testGetElementos() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.hojaUno, this.hojaDos);
		//Verify
		assertEquals(composicionEsperada,this.nodo.getElementos());
	}

	@Test
	void testNodoFormaUnaComposiciónConHojaUno() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.nodo, this.hojaUno);
		//Excercise
		IShapeShifter composicion = this.nodo.compose(this.hojaUno);
		//Verify
		assertEquals(composicionEsperada, ((ShapeShifter) composicion).getElementos());
	}		
}
