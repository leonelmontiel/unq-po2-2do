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
	private Nodo nodoTres;
	private ShapeShifter hojaUno = mock(Hoja.class);
	private ShapeShifter hojaDos = mock(Hoja.class);

	@BeforeEach
	void setUp() throws Exception {
		this.nodoUno = new Nodo(this.hojaUno, this.hojaDos);
		this.nodoDos = new Nodo(this.nodoUno, this.hojaUno);
		this.nodoTres = new Nodo(this.nodoUno, this.nodoDos);
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
	
	@Test
	void testNodoUnoProfundidadEsUno() {
		//Excercise
		int profundidadObtenida = this.nodoUno.deepest();
		//Verify
		//NodoUno está compuesto por HojaUno y HojaDos, de profundidad 0 cada una. Por ende se espera que la profundidad del nodo sea de 1
		assertEquals(1, profundidadObtenida);
	}
	
	@Test
	void testNodoDosProfundidadEsDos() {
		//Excercise
		int profundidadObtenida = this.nodoDos.deepest();
		//Verify
		//NodoDos está compuesto por NodoUno (prof 1) y HojaUno (prof 0). Por ende se espera que la profundidad del nodoDos sea de 2
		assertEquals(2, profundidadObtenida);
	}
	
	@Test
	void testNodoTresProfundidadEs3() {
		//Excercise		
		int profundidadObtenida = this.nodoTres.deepest();
		//Verify
		//NodoTres está compuesto por NodoUno (prof 1) y nodoDos (prof 2). Por ende se espera que la profundidad del nodoTres sea de 3
		assertEquals(3, profundidadObtenida);
	}
}
