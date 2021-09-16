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
	void testNumConMasPares() {
		int n = desarmador.numConMasPares(arregloNumeros);
		
		assertEquals(6248, n);
	}
	
	@Test
	void testNumComMasPares() {
		int i = 6248;
		int j = 4567;
		
		assertEquals(6248, desarmador.numeroConMasParesEntre(i, j));
	}
	
	@Test
	void tesCantParesDeConCuatroPares() {
		int n = 6248;
		
		assertEquals(4, desarmador.cantParesDe(n));
	}
	
	@Test
	void tesCantParesDeConUnPar() {
		int n = 3525;
		
		assertEquals(1, desarmador.cantParesDe(n));
	}
	
	@Test
	void tesCantDeCifras() {
		int n = 6248;
		
		assertEquals(4, desarmador.cantCifras(n));
	}

}
