package ar.edu.unq.po2.tp7;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		this.cliente = new Cliente("Leo", "Perez", 30, "Calle Falsa 123", 20000f);
	}

	@Test
	void testGetNombre() {
		assertEquals("Leo", this.cliente.getNombre());
	}
	
	@Test
	void testGetApellido() {
		assertEquals("Perez", this.cliente.getApellido());
	}
	
	@Test
	void testGetEdad() {
		assertEquals(30, this.cliente.getEdad());
	}

	@Test
	void testGetDireccion() {
		assertEquals("Calle Falsa 123", this.cliente.getDireccion());
	}
	
	@Test
	void testGetSueldoNeto() {
		assertEquals(20000f, this.cliente.getSueldoNetoMensual());
	}
	
	@Test 
	void testGetSueldoNetoAnual() {
		assertEquals(240000f, this.cliente.getSueldoNetoAnual());
	}
	
	///////////////////////////
		
	@Test
	void testNombreNoPuedeEstarEnBlanco() {
	assertThrows(RuntimeException.class, () -> Cliente.nuevo(""));
	}
	
}
