package ar.edu.unq.po2.template.sueldo;

import org.junit.jupiter.api.BeforeEach;

class TemporarioTest extends EmpleadoTest{

	@BeforeEach
	void setUp() throws Exception {
		this.empleado = new Temporario(10, false, 2);
		this.sueldoEsperado = 1783.5f; // $2050 de sueldo pero quedan $1783.5 por el 13% de descuento
	}

}
