package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudPersonalTest extends SolicitudCreditoTest{

	@BeforeEach
	void setUp() throws Exception {
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 20000f);
		this.solicitudCredito = new SolicitudCreditoPersonal(cliente, 20000f, 12);
		
	}
	
	@Test
	void testEsAceptable() {
		assertTrue(solicitudCredito.esAceptable());
	}

}
