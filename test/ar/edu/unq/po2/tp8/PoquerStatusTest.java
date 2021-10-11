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

	/*
	@Test
	void testHayPokerV1() {
		//Excercise
		boolean hayPoker = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		
		//verify
		assertTrue(hayPoker);
	}
	
	@Test
	void testNoHayPokerV1() {
		carta4 = "5T";
		//Excercise
		boolean hayPoker = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		
		//verify
		assertFalse(hayPoker);
	}
	
	@Test
	void testCartasSoloConSusValores() {
		//SetUp
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		List<String> valoresDeseados = Arrays.asList("2", "2", "2", "2", "Q");
		
		//Excercise
		List<String> valoresObtenidos = pokerStatus.cartasSoloConValores(cartas);
		
		//verify
		assertEquals(valoresDeseados, valoresObtenidos);
	}
	
	@Test
	void testHayPokerV2() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Póquer".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayPokerV2() {
		//SetUp
		carta1 = "QT";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		assertFalse("Póquer".equals(cadenaObtenida));
	}
	
	@Test
	void testHayTrio() {
		//Setup
		carta1 = "KD";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Trío".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayTrio() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("Trío".equals(cadenaObtenida));
	}
	
	@Test
	void testHayColor() {
		//SetUp
		carta1 = "KD";	carta2 = "2D";	carta3 = "JD";	carta4 = "10D";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Color".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayColor() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("Color".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayNada() {
		//SetUp
		carta1 = "KD";	carta2 = "2D";	carta3 = "JD";	carta4 = "10D"; carta5 = "AP";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Nada".equals(cadenaObtenida));
	}*/
	
	

}
