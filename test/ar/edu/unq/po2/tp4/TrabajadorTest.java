package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTest {
	Trabajador trabajador;
	Ingreso ingresoA;
	Ingreso ingresoB;
	IngresoHorasExtras ingresoC;
	IngresoHorasExtras ingresoD;

	@BeforeEach
	void setUp() throws Exception {
		trabajador = new Trabajador("Enero", "Sueldo", 10000);
		ingresoA = new Ingreso("Febrero", "Sueldo", 10000);
		ingresoB = new IngresoHorasExtras("Marzo", "Horas Extras", 200, 2);
		ingresoC = new IngresoHorasExtras("abril", "Horas Extras", 400, 4);
	}

	@Test
	void totalPercibidoTest20600() {
		double monto = 20600;
		double total = trabajador.getTotalPercibido();
		
		assertEquals(monto, total);
	}

}
