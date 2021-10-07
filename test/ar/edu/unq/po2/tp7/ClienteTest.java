package ar.edu.unq.po2.tp7;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 40000f);
	}

	@Test
	void testNombreLeo() {
		assertEquals("Leo", cliente.getNombre());
	}
	
	@Test
	void testApellidoPerez() {
		assertEquals("Perez", cliente.getApellido());
	}
	
	@Test
	void testEdad30() {
		assertEquals(30, cliente.getEdad());
	}
	
	@Test
	void testDireccionCalleFalsa() {
		assertEquals("Calle Falsa 123", cliente.getDireccion());
	}
	
	@Test
	void testSueldo40000() {
		assertEquals(40000f, cliente.getSueldoNetoMensual());
	}
	
	////////////////////////////
	
	@Test
	void testSueldoNetoAnual480000() {
		assertEquals(480000f, cliente.getSueldoNetoAnual());
	}
	
	///////////////////////////
	
	@Test
	void testNombreNoPuedeEstarEnBlanco() {
		assertThrows(RuntimeException.class, () -> Cliente.nuevo(""));
	}
}
