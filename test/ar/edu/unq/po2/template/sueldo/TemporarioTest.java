package ar.edu.unq.po2.template.sueldo;

import org.junit.jupiter.api.BeforeEach;

class TemporarioTest extends EmpleadoTest{

	@BeforeEach
	void setUp() throws Exception {
		this.empleado = new Temporario(1000f, 100, false, 2);
		this.sueldoEsperado = 1392f; // $1600 de sueldo pero quedan $1392 por el 13% de descuento
	}

}
