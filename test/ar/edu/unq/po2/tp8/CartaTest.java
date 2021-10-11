package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	private Carta carta1; //SUT
	private Carta carta2; //Doc

	@BeforeEach
	void setUp() throws Exception {
		//SetUp
		carta1 = new Carta(Valor.A, Palo.PICA);
		carta2 = new Carta(Valor.DOS, Palo.TREBOL);
	}

	@Test
	void testEsMayorQueCarta2() {
		//Excercise
		boolean esMayorQue = carta1.esMayorQue(carta2);
		//Verify
		assertTrue(esMayorQue);
	}
	
	@Test
	void testEsMenorQueCarta2() {
		//Excercise
		boolean esMayorQue = carta2.esMayorQue(carta1);
		//Verify
		assertFalse(esMayorQue);
	}
	
	@Test
	void testCarta1YCarta2SonDelMismoValor() {
		//SetUp
		carta1 = new Carta(Valor.DOS, Palo.PICA);
		//Excercise
		boolean esMayorQue = carta1.esMayorQue(carta2);
		//Verify
		assertFalse(esMayorQue);
	}
	
	@Test
	void testPoseenElMimoPalo() {
		//SetUp
		carta1 = new Carta(Valor.A, Palo.TREBOL);
		//Excercise
		boolean mismoPalo = carta1.tieneMismoPaloQue(carta2);
		
		assertTrue(mismoPalo);
	}
	
	@Test
	void testNoPoseenElMimoPalo() {
		//Excercise
		boolean mismoPalo = carta1.tieneMismoPaloQue(carta2);
		//Verify
		assertFalse(mismoPalo);
	}

}
