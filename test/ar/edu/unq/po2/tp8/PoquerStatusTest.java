package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoquerStatusTest {

	private PokerStatus pokerStatus; //SUT
	private Carta carta1 = mock(Carta.class);
	private Carta carta2 = mock(Carta.class);
	private Carta carta3 = mock(Carta.class);
	private Carta carta4 = mock(Carta.class);
	private Carta carta5 = mock(Carta.class);
	private List<?> listaValores;

	@BeforeEach
	void setUp() throws Exception {
		//Setup
		pokerStatus = new PokerStatus(); //SUT
		/*carta1 = "2D";
		carta2 = "2P";
		carta3 = "2C";
		carta4 = "2T";
		carta5 = "QD";*/
		when(this.carta1.getValor()).thenReturn(Valor.DOS); when(this.carta1.getPalo()).thenReturn(Palo.DIAMANTE);
		when(this.carta2.getValor()).thenReturn(Valor.DOS); when(this.carta2.getPalo()).thenReturn(Palo.PICA);
		when(this.carta3.getValor()).thenReturn(Valor.DOS); when(this.carta3.getPalo()).thenReturn(Palo.CORAZON);
		when(this.carta4.getValor()).thenReturn(Valor.DOS); when(this.carta4.getPalo()).thenReturn(Palo.TREBOL);
		when(this.carta5.getValor()).thenReturn(Valor.Q); when(this.carta5.getPalo()).thenReturn(Palo.DIAMANTE);
		
		listaValores = Arrays.asList(Valor.DOS, Valor.DOS, Valor.DOS, Valor.DOS, Valor.Q);
		
	}
	
	@Test
	void testHayPoquer() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("P�quer".equals(cadenaObtenida));
		assertFalse("Nada".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayPoquer() {
		//SetUp
		when(this.carta1.getValor()).thenReturn(Valor.CINCO); when(this.carta1.getPalo()).thenReturn(Palo.PICA);
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("P�quer".equals(cadenaObtenida));
		assertTrue("Tr�o".equals(cadenaObtenida));
	}
	
	@Test
	void testCartasSoloConValores() {
		//SetUp		
		List<Carta> listaDeCartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		//Excercise
		List<?> listaValoresObtenidos = pokerStatus.cartasSoloConValores(listaDeCartas);
		//Verify
		assertEquals(listaValores, listaValoresObtenidos);
	}
	
	@Test
	void testCantValoresEquivaleA() {
		//Excercise
		boolean cantEquivaleANum = pokerStatus.cantEquivaleA(listaValores, 4); //pongo 4 para que concuerde con los valores repetidos de la
		//lista de valores (son 4 valores DOS)
		//Verify
		assertTrue(cantEquivaleANum);
	}
	
	@Test
	void testCantValoresNoEquivaleA() {
		//SetUp
		List<?> listaValores = Arrays.asList(Valor.DOS, Valor.DOS, Valor.DOS, Valor.CINCO, Valor.Q); //cambio uno de los valores DOS a CINCO
		//Excercise
		boolean cantEquivaleANum = pokerStatus.cantEquivaleA(listaValores, 4); //pongo 4 para que no concuerde con los valores repetidos de la
		//lista de valores (son 3 valores DOS)
		//Verify
		assertFalse(cantEquivaleANum);
	}
	
	@Test
	void testContarRepeticionesDeValor() {
		//SetUp
		long cantEsperada = 4;
		//Excercise
		long cantRepeticiones = pokerStatus.contarRepeticionesDe(Valor.DOS, listaValores); //hago que cuente las repeticiones del valor DOS en la lista
		//de valores del setup
		//Verify
		assertEquals(cantEsperada, cantRepeticiones);
	}
	
	@Test
	void testContarRepeticionesDeValorMaleSal() {
		//SetUp
		long cantEsperada = 3; //se supone que en la lista de valores hay 4 DOS
		//Excercise
		long cantRepeticiones = pokerStatus.contarRepeticionesDe(Valor.DOS, listaValores); //hago que cuente las repeticiones del valor DOS en la lista
		//de valores del setup
		//Verify
		assertNotEquals(cantEsperada, cantRepeticiones);
	}
	
	@Test
	void testHayTrio() {
		//SetUp
		when(this.carta1.getValor()).thenReturn(Valor.A); when(this.carta1.getPalo()).thenReturn(Palo.PICA);// hago que solo haya 3 cartas del mismo valor
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Tr�o".equals(cadenaObtenida));
		assertFalse("Nada".equals(cadenaObtenida));
		assertFalse("P�quer".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayTrio() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("Tr�o".equals(cadenaObtenida));
		assertTrue("P�quer".equals(cadenaObtenida));
		assertFalse("Nada".equals(cadenaObtenida));
	}
	
	@Test
	void testHayColor() {
		//SetUp
		carta2 = new Carta(Valor.A, Palo.DIAMANTE); carta3 = new Carta(Valor.J, Palo.DIAMANTE); carta4 = new Carta(Valor.SIETE, Palo.DIAMANTE);
		// ahora las cinco cartas son del mismo palo
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Color".equals(cadenaObtenida));
		assertFalse("Tr�o".equals(cadenaObtenida));
		assertFalse("Nada".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayColor() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("Color".equals(cadenaObtenida));
		assertTrue("P�quer".equals(cadenaObtenida));
		assertFalse("Tr�o".equals(cadenaObtenida));
		assertFalse("Nada".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayJugada() {
		//SetUp
		when(this.carta2.getValor()).thenReturn(Valor.A);
		when(this.carta3.getValor()).thenReturn(Valor.J); when(this.carta2.getPalo()).thenReturn(Palo.PICA);
		when(this.carta4.getValor()).thenReturn(Valor.SIETE); when(this.carta1.getPalo()).thenReturn(Palo.CORAZON);
		// ahora no hay jugadas posibles
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Nada".equals(cadenaObtenida));
		assertFalse("P�quer".equals(cadenaObtenida));
		assertFalse("Tr�o".equals(cadenaObtenida));
		assertFalse("Color".equals(cadenaObtenida));
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
		assertTrue("P�quer".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayPokerV2() {
		//SetUp
		carta1 = "QT";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		assertFalse("P�quer".equals(cadenaObtenida));
	}
	
	@Test
	void testHayTrio() {
		//Setup
		carta1 = "KD";
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertTrue("Tr�o".equals(cadenaObtenida));
	}
	
	@Test
	void testNoHayTrio() {
		//Excercise
		String cadenaObtenida = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertFalse("Tr�o".equals(cadenaObtenida));
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
