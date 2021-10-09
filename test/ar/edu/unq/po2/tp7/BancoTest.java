package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco;
	private Cliente cliente;
	private Inmueble inmueble;
	private SolicitudCredito solicitud;
	private SolicitudCredito solicitudA;
	private SolicitudCredito solicitudR;
	
	@BeforeEach
	void setUp() throws Exception {
		this.banco = new Banco();
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 20000f);
		this.inmueble = new Inmueble("Depto", "Calle Falsa 321", 40000f);
		this.solicitud = new SolicitudPersonal(this.cliente, 20000f, 12);
		this.solicitudA = new SolicitudPersonal(this.cliente, 5000f, 12);
		this.solicitudR = new SolicitudHipotecario(this.cliente, 30000f, 12, this.inmueble);
	}

	@Test
	void testUnBancoNuevoNoTieneClientes() {
		assertFalse(this.banco.tieneClientes());
	}
	
	@Test
	void testUnBancoAgregaUnCliente() {
		this.banco.agregar(cliente);
		assertTrue(this.banco.tieneClientes());
	}
	
	@Test
	void testUnBancoNuevoNoTieneSolicitudes() {
		assertFalse(this.banco.tieneSolicitudes());
	}
	
	@Test
	void testUnBancoRegistraUnaSolicitud() {
		this.banco.registrar(this.solicitud);
		assertTrue(this.banco.tieneSolicitudes());
	}
	
	@Test
	void testMontoTotalADesenbolsar() {
		this.banco.registrar(solicitud);
		this.banco.registrar(solicitudA);
		this.banco.registrar(solicitudR);
		assertEquals(25000f, this.banco.getTotalADesembolsar());
	}

}
