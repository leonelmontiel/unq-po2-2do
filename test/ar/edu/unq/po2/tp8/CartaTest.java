package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	private Carta carta1; //SUT
	private Carta carta2;

	@BeforeEach
	void setUp() throws Exception {
		carta1 = new Carta(Valor.A, Palo.PICA);
		carta2 = new Carta(Valor.DOS, Palo.TREBOL);
	}

	@Test
	void testEsMayorQueCarta2() {
		boolean esMayorQue = carta1.esMayorQue(carta2);
		
		assertTrue(esMayorQue);
	}
	
	@Test
	void testEsMenorQueCarta2() {
		boolean esMayorQue = carta2.esMayorQue(carta1);
		
		assertFalse(esMayorQue);
	}

}
