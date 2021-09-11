package ar.edu.unq.po2.tp3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {

	private List<Integer> coord = new ArrayList<Integer>();
	private Punto puntoA = new Punto();
	private Punto puntoB;
	private List<Integer> coordCuatroCinco = Arrays.asList(4, 5);

	@BeforeEach
	void setUp() throws Exception {
		puntoB = new Punto(4, 5);
	}

	@Test
	void testCoordOrigen() {
		List<Integer> origen = Arrays.asList(0, 0);
		coord = puntoA.getCoordenadas();
		assertEquals(coord, origen);
	}
	
	@Test
	void testCoordEstablecida() {
		// las coordenada de prueba establecidas en el test se encuentran en el setUp
		coord = puntoB.getCoordenadas();
		assertEquals(coord, coordCuatroCinco);
	}
	
	@Test
	void testMoverCoordA() {
		List<Integer> coordOchoUno = Arrays.asList(8, 1);
		puntoB.moverCoordA(8, 1);
		coord = puntoB.getCoordenadas();
		assertEquals(coord, coordOchoUno);
	}
	
	@Test
	void testSumarCoord() {
		puntoB.sumarseCon(2, 5);
		List<Integer> coordSeisDiez = Arrays.asList(6, 10);
		coord = puntoB.getCoordenadas();
		assertEquals(coord, coordSeisDiez);
	}

}
