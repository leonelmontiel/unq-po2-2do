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
		this.hojaUno = new Hoja();
		this.hojaDos = new Hoja();
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
	void testHojaNoPuedeSerUnaComposición() {
		assertEquals(null,this.hojaUno.getElementos());		
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

}
