package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

abstract class SolicitudCreditoTest {

	protected SolicitudCredito solicitud;
	protected Cliente cliente;

	@Test
	void testGetCliente() {
		assertEquals(this.cliente, solicitud.getCliente());
	}
	
	@Test
	void testGetMonto() {
		assertEquals(20000f, solicitud.getMonto());
	}
	
	@Test
	void testGetPlazo() {
		assertEquals(12, this.solicitud.getPlazo());
	}
	
	@Test 
	void testGetCuotaMensual(){
		assertEquals(1666.66667f, this.solicitud.getCuotaMensual());
	}
	
}
