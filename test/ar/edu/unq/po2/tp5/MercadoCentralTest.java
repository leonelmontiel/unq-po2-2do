package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MercadoCentralTest {
	private MercadoCentral mercado;
	private Producto detergente;
	private ProductoCooperativa arroz;

	@BeforeEach
	void setUp() throws Exception {
		mercado = new MercadoCentral();
		detergente = new Producto("Magistral", 60);
		arroz = new ProductoCooperativa("Marolio", 30);
		
		mercado.addProducto(detergente);
		mercado.addProducto(arroz);
	}

	@Test
	void dosProductosEnStockTest() {		
		assertEquals(2, mercado.getStock().size());
	}
	
	@Test
	void hayStockDeDetergenteTest() {		
		assertTrue(mercado.hayStockDe(detergente));
	}
	
	@Test
	void hayStockDeArrozTest() {		
		assertTrue(mercado.hayStockDe(arroz));
	}
	
	@Test
	void decrementarStockDeArrozConStockDeUnoTest() {
		mercado.decrementarStockDe(arroz);
		
		//teniendo en cuenta que hay solo un arroz en stock; el test deber�a arrojar que no hay ning�n arroz
		assertFalse(mercado.hayStockDe(arroz));
		//teniendo en cuenta que hay dos productos en stock; deber�a quedar uno solo que es el detergente
		assertEquals(1, mercado.getStock().size());
	}
	
	@Test
	void decrementarStockDeArrozConStockDeDosTest() {
		mercado.addProducto(arroz);
		mercado.decrementarStockDe(arroz);
		
		//teniendo en cuenta que hay dos arroces en stock; el test deber�a arrojar que hay un arroz a�n
		assertTrue(mercado.hayStockDe(arroz));
		//teniendo en cuenta que hay tres productos en stock; deber�an quedar dos que son el detergente y un arroz m�s
		assertEquals(2, mercado.getStock().size());
	}

}
