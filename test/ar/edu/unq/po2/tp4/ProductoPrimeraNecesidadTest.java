package ar.edu.unq.po2.tp4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	
	@BeforeEach
	public void setUp() {
	}
	
	@SuppressWarnings("removal")
	@Test
	public void testCalcularPrecioDescuentoDel10() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 10);
		assertEquals(new Double(7.2), leche.getPrecio());
	}
	
	@SuppressWarnings("removal")
	@Test
	public void testCalcularPrecioDescuentoDel25() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 25);
		assertEquals(new Double(6), leche.getPrecio());
	}
}
