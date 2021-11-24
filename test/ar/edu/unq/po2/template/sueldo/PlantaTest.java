package ar.edu.unq.po2.template.sueldo;

import org.junit.jupiter.api.BeforeEach;

class PlantaTest extends EmpleadoTest {

	@BeforeEach
	void setUp() throws Exception {
		this.empleado = new Planta(2);
		this.sueldoEsperado = 2871f; // $3300 de sueldo neto, pero quedan $2871 de sueldo bruto
	}

}
