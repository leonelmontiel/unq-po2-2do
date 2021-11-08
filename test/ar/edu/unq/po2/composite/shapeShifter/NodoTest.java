package ar.edu.unq.po2.composite.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodoTest {
	
	private Nodo nodoUno;
	private Nodo nodoDos;
	private ShapeShifter hojaUno = mock(Hoja.class);
	private ShapeShifter hojaDos = mock(Hoja.class);

	@BeforeEach
	void setUp() throws Exception {
		this.nodoUno = new Nodo(this.hojaUno, this.hojaDos);
		this.nodoDos = new Nodo(this.nodoUno, this.hojaUno);
	}
	
	@Test
	void testNodoContieneElementos() {
		assertTrue(this.nodoUno.contiene(this.hojaUno));
		assertTrue(this.nodoUno.contiene(this.hojaDos));
	}
	
	@Test
	void testGetElementos() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.hojaUno, this.hojaDos);
		//Verify
		assertEquals(composicionEsperada,this.nodoUno.getElementos());
	}

	@Test
	void testNodoFormaUnaComposiciónConHojaUno() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.nodoUno, this.hojaUno);
		//Excercise
		IShapeShifter composicion = this.nodoUno.compose(this.hojaUno);
		//Verify
		assertEquals(composicionEsperada, ((ShapeShifter) composicion).getElementos());
	}	
	
	@Test
	void testNodoUnoFormaUnaComposiciónConNodoDos() {
		//SetUp
		List<IShapeShifter> composicionEsperada = Arrays.asList(this.nodoUno, this.nodoDos);
		//Excercise
		IShapeShifter composicion = this.nodoUno.compose(this.nodoDos);
		//Verify
		assertEquals(composicionEsperada, ((ShapeShifter) composicion).getElementos());
	}
}
