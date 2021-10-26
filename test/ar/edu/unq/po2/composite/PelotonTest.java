package ar.edu.unq.po2.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class PelotonTest {
	protected Peloton parteDelPeloton; //SUT
	protected int destino;
	
	@BeforeEach
	void setUp() throws Exception {
		this.destino = 15;
	}

	@Test
	void testUbicacionInicialEs0Pasos() {
		//SetUp
		int ubicacionInicial = 0;
		assertEquals(ubicacionInicial, this.parteDelPeloton.getUbicacion());
	}
	
	@Test
	void testAvanzarHaciaDestino() {
		this.parteDelPeloton.caminarHasta(destino);
		//Verify
		assertEquals(destino, this.parteDelPeloton.getUbicacion());
	}

}
