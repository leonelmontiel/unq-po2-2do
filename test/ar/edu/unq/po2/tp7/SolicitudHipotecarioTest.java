package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudHipotecarioTest extends SolicitudCreditoTest {

	private Inmueble inmueble;
	private SolicitudHipotecario noAceptable;
	private SolicitudHipotecario noAceptableEdad;
	private SolicitudHipotecario noAceptableMonto;
	private Cliente clienteMayor;
	
	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble("Depto", "Calle Falsa 321", 40000f);
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 20000f);
		this.clienteMayor = new Cliente("Leo", "Garcia", 65, "Otra Calle Falsa", 20000f);
		this.solicitud = new SolicitudHipotecario(this.cliente, 20000f, 12, this.inmueble);
		this.noAceptable = new SolicitudHipotecario(this.cliente, 200000f, 12, this.inmueble);
		this.noAceptableMonto = new SolicitudHipotecario(this.cliente, 30000f, 12, this.inmueble);
		this.noAceptableEdad = new SolicitudHipotecario(this.clienteMayor, 20000f, 12, this.inmueble);
	}

	@Test
	void testGetGarantia() {
		assertEquals(this.inmueble, ((SolicitudHipotecario) this.solicitud).getGarantia());
	}

	@Test
	void testEsAceptable() {
		assertTrue(this.solicitud.esAceptable());
	}

	@Test
	void testNoEsAceptablePorValorCuota() {
		assertFalse(this.noAceptable.esAceptable());
	}
	
	@Test
	void testNoEsAceptablePorMonto() {
		assertFalse(this.noAceptableMonto.esAceptable());
	}

	@Test 
	void testNoEsAceptablePorEdad() {
		assertFalse(this.noAceptableEdad.esAceptable());
	}
}
