package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesarmarNumeroTest {
	private DesarmadorNum desarmador;
	private int[] arregloNumeros;

	@BeforeEach
	void setUp() throws Exception {
		desarmador = new DesarmadorNum();
		
		int nElementos = 3; //cantidad de prueba
		arregloNumeros = new int[nElementos];
		
		//elementos de prueba
		arregloNumeros[0] = 6248;
		arregloNumeros[1] = 22345;
		arregloNumeros[2] = 4567;
	}

	@Test
	void test() {
		int n = desarmador.numConMasPares(arregloNumeros);
		
		assertEquals(n, 6248);
	}

}
