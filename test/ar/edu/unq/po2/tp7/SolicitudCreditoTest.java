package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

abstract class SolicitudCreditoTest {

	protected SolicitudCredito solicitudCredito;
	protected Cliente cliente;


	@Test
	void testMontoEs20000() {
		assertEquals(20000f, solicitudCredito.getMonto());
	}
	
	@Test
	void testPlazo12() {
		assertEquals(12, solicitudCredito.getPlazo());
	}
	
	//////////////////
	
	@Test
	void testCuotaMensual1666_66667() {
		assertEquals(1666.66667f, solicitudCredito.getCuotaMensual());
	}
	
	@Test
	void testConoceAlClienteLeo() {		
		assertEquals(cliente, solicitudCredito.getCliente());
	}

}
