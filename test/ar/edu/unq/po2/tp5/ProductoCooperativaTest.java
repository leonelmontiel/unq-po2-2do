package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoCooperativaTest {
	ProductoCooperativa producto;

	@BeforeEach
	void setUp() throws Exception {
		producto = new ProductoCooperativa("arroz", 30);
	}

	@Test
	void precioConDescuentoA27() {
		// al precio original se le aplica un 10% de descuento
		assertEquals(27, producto.getPrecio());
	}

}
