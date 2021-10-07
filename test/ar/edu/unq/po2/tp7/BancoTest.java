package ar.edu.unq.po2.tp7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco;
	private Cliente cliente;
	private SolicitudCredito solicitud;

	@BeforeEach
	void setUp() throws Exception {
		banco = new Banco();
	}

	@Test
	void testBancoSinClientes() {
		assertFalse(banco.tieneClientes());
	}
	
	@Test
	void testBancoSinSolicitudes() {
		assertFalse(banco.tieneSolicitudes());
	}
	
	//////////////////////
	
	@Test
	void testAgregarClienteABanco() {
		banco.agregarCliente(cliente);
		assertTrue(banco.tieneClientes());
	}
	
	@Test
	void testRegistrarSolicitudABanco() {
		banco.registrarSolicitud(solicitud);
		assertTrue(banco.tieneSolicitudes());
	}
	
	/////////////////////


}
