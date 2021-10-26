package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngenieroTest extends PelotonTest{

	private int lajas;

	@BeforeEach
	void setUp() throws Exception {
		//SetUp
		// comienza con 10 lajas en su bolsa
		this.lajas = 10;
		this.parteDelPeloton = new Ingeniero(this.lajas);
	}
	
	@Test
	void testTiene10LajasEnSuBolsa() {
		//Verify
		assertEquals(((Ingeniero) this.parteDelPeloton).getLajas(), this.lajas);
	}

	@Test
	void testCaminarDejandoLajasHaciendo5Pasos() {
		//Excercise
		System.out.println("\n" + "testCaminarDejandoLajasHaciendo5Pasos(): ");
		Integer destino = 5; // representa los pasos hasta un determinado destino
		this.parteDelPeloton.caminarHasta(destino);
		//Verify
		assertTrue(((Ingeniero) this.parteDelPeloton).getLajas() == 5);
	}
	
	@Test
	void testCaminarDejandoLas10LajasHaciendo12Pasos() {
		//Excercise
		System.out.println("\n" + "testCaminarDejandoLas10LajasHaciendo12Pasos(): ");
		Integer destino = 12; // representa los pasos hasta un determinado destino
		this.parteDelPeloton.caminarHasta(destino);
		//Verify
		assertTrue(((Ingeniero) this.parteDelPeloton).getLajas() == 0);
	}
	
	@Override
	@Test
	void testReclutarIngeniero() {
		// No puede reclutar
	}
	
	@Test
	void testNoPuedeReclutar() {
		//Excercise
		this.parteDelPeloton.reclutar(ingeniero);
		boolean pelotonContieneAIngeniero = this.parteDelPeloton.luchadores.contains(ingeniero);
		//Verify
		assertFalse(pelotonContieneAIngeniero);
	}
	
	@Override
	@Test
	void testDesterrarDelPelotonAIngeniero() {
		// No puede desterrar a nadie ya que no puede reclutar
	}
	
	@Test
	void testDejarLaja() {
		//Excercise
		((Ingeniero) this.parteDelPeloton).dejarLaja();
		int lajasEsperadas = this.lajas - 1;
		int lajasQueQuedan = ((Ingeniero)this.parteDelPeloton).getLajas();
		//Verify
		assertEquals(lajasEsperadas, lajasQueQuedan);
	}
	
	@Test
	void testTrazarCamino() {
		//Excercise
		int destino = 15; //pasos
		int pasosADar = ((Ingeniero) this.parteDelPeloton).trazarCaminoCortoHacia(destino);
		//Verify
		assertEquals(destino, pasosADar);
	}
	
}
