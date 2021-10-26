package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaballeroTest extends PelotonTest{

	@BeforeEach
	void setUp() throws Exception {
		//SetUp
		this.parteDelPeloton = new Caballero();
	}
	
	@Test
	void testCaminarEnZigZag() {
		// Excercise
		int destino = 8; //pasos a dar hasta la ubicación
		this.parteDelPeloton.caminarHasta(destino);
		//Verify
		assertEquals(destino, this.parteDelPeloton.getUbicacion());
	}

}
