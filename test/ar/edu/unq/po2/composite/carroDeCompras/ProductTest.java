package ar.edu.unq.po2.composite.carroDeCompras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private Product product;//SUT

	@BeforeEach
	void setUp() throws Exception {
		this.product = new Product("Queso", 400.45f);
	}

	@Test
	void testGetPrice() {
		//Excercise
		Float precioObtenido = this.product.getPrice();
		assertEquals(400.45f, precioObtenido);
	}
	
	@Test
	void testGetName() {
		//Excercise
		String nombreObtenido = this.product.getName();
		assertEquals("Queso", nombreObtenido);
	}

}
