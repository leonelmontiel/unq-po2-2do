package ar.edu.unq.po2.template.sueldo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmpleadoTest {

	protected Empleado empleado;
	protected Float sueldoEsperado;

	@Test
	void testSueldoOk() {
		Float sueldoObtenido = this.empleado.sueldo();
		assertEquals(this.sueldoEsperado, sueldoObtenido);
	}

}
