package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudPersonalTest extends SolicitudCreditoTest {

	private SolicitudPersonal solicitudNoAceptable;
	private SolicitudPersonal solicitudNoAceptableCuota;
	private Cliente clienteBajoSueldo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123",20000f);
		this.solicitud = new SolicitudPersonal(this.cliente, 20000f, 12);
		this.clienteBajoSueldo = new Cliente("Leo", "Garcia", 30, "Otra Calle Falsa",200f);
		this.solicitudNoAceptable = new SolicitudPersonal(this.clienteBajoSueldo, 170000f, 12);
		this.solicitudNoAceptableCuota = new SolicitudPersonal(this.cliente, 170000f, 12);
	}

	@Test
	void testEsAceptable() {
		assertTrue(this.solicitud.esAceptable());
	}
	
	@Test
	void testNoEsAceptablePorSueldo() {
		assertFalse(this.solicitudNoAceptable.esAceptable());
	}
	
	@Test
	void testNoEsAceptablePorValorCuota() {
		assertFalse(solicitudNoAceptableCuota.esAceptable());
	}
			
}
