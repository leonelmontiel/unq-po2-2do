package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoquerStatusTest {

	private PokerStatus pokerStatus; //SUT
	private String carta1;
	private String carta2;
	private String carta3;
	private String carta4;
	private String carta5;

	@BeforeEach
	void setUp() throws Exception {
		//Setup
		pokerStatus = new PokerStatus();
		carta1 = "2D";
		carta2 = "2P";
		carta3 = "2C";
		carta4 = "2T";
		carta5 = "QD";
	}

	@Test
	void testEsPoker() {
		//Excercise
		boolean esPoker = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		
		//verify
		assertTrue(esPoker);
	}
	
	@Test
	void testNoEsPoker() {
		carta4 = "5T";
		//Excercise
		boolean esPoker = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		
		//verify
		assertFalse(esPoker);
	}
	
	@Test
	void testCartasSoloConSusValores() {
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		List<String> valoresDeseados = Arrays.asList("2", "2", "2", "2", "Q");
		
		//Excercise
		List<String> valoresObtenidos = pokerStatus.cartasSoloConValores(cartas);
		
		//verify
		assertEquals(valoresDeseados, valoresObtenidos);
	}
	
	

}
