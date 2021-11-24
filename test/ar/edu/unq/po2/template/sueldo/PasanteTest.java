package ar.edu.unq.po2.template.sueldo;

import org.junit.jupiter.api.BeforeEach;

class PasanteTest extends EmpleadoTest{

	@BeforeEach
	void setUp() throws Exception {
		this.empleado = new Pasante(10);
		this.sueldoEsperado = 348f; // $400 por horas trabajadas en el mes pero quedan $348 por el 13% de descuento
	}

}
