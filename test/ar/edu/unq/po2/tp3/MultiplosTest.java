package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplosTest {
	private MayorMultiplo mult;
	int x;
	int y;

	@BeforeEach
	void setUp() throws Exception {		
		mult = new MayorMultiplo();
	}

	@Test
	void testMayorMultiploTresYNueve() {
		x = 3;
		y = 9;
		int valorEsperado = 999;
		
		assertEquals(valorEsperado, mult.mayorMultiploEntre(x, y));
	}
	
	@Test
	void testMayorMultiploDosYCinco() {
		x = 2;
		y = 5;
		int valorEsperado = 1000;
		
		assertEquals(valorEsperado, mult.mayorMultiploEntre(x, y));
	}
	
	@Test
	void testNoExisteMultiploMayor() {
		x = 100;
		y = 120;
		int valorEsperado = -1;
		
		assertEquals(valorEsperado, mult.mayorMultiploEntre(x, y));
	}

}
