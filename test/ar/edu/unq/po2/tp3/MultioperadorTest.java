package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultioperadorTest {

	private Integer amount;
	private Multioperador multioperador;
	private int[] arreglo;

	@BeforeEach
	void setUp() throws Exception {
		multioperador = new Multioperador();
		arreglo = new int[5];
		
		arreglo[0] = 4;
		arreglo[1] = 2;
		arreglo[2] = 5;
		arreglo[3] = 1;
		arreglo[4] = 3;
		
		multioperador.addArregloEnteros(arreglo);		
	}

	@Test
	void testAddAll() {
		amount = multioperador.addAll();
		assertEquals(amount, 15);
	}
	
	@Test
	void testRestAll() {
		amount = multioperador.restAll();
		assertEquals(amount, -7);
	}
	
	@Test
	void testMultiplyAll() {
		amount = multioperador.multiplyAll();
		assertEquals(amount, 120);
	}

}
