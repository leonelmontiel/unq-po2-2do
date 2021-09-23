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
		trabajador = new Trabajador();
		ingresoA = new Ingreso("Enero", "Sueldo", 10000);
		ingresoB = new Ingreso("Febrero", "Sueldo", 10000);
		ingresoC = new IngresoHorasExtras("Enero", "Horas Extras", 200, 2);
		ingresoD = new IngresoHorasExtras("Febrero", "Horas Extras", 400, 4);
		
		trabajador.agregarIngreso(ingresoA);
		trabajador.agregarIngreso(ingresoB);
		trabajador.agregarIngreso(ingresoC);
		trabajador.agregarIngreso(ingresoD);
	}

	@Test
	void totalPercibidoTest20600() {
		double monto = 20600;
		double total = trabajador.getTotalPercibido();
		
		assertEquals(monto, total);
	}
	
	@Test
	void totalMontoImponible20000() {
		double monto = 20000;
		double total = trabajador.getMontoImponible();
		
		assertEquals(monto, total);
	}
	
	@Test
	void totalImpuestoAPagar400() {
		double monto = 400;
		double total = trabajador.getImpuestoAPagar();
		
		assertEquals(monto, total);
	}

}
