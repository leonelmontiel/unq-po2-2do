package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudHipotecarioTest extends SolicitudCreditoTest {

	private Inmueble garantia;

	@BeforeEach
	void setUp() throws Exception {
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 20000f);
		this.solicitudCredito = new SolicitudCreditoHipotecario(cliente, 20000f, 12, garantia);
	}

	@Test
	void testGetGarantia() {
		assertEquals(garantia, ((SolicitudCreditoHipotecario) solicitudCredito).getGarantia());
	}

}
