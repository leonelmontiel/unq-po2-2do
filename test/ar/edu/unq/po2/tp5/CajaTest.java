package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {
	Caja caja; // SUT
	MercadoCentral mercado;
	Producto detergente;
	ProductoCooperativa arroz;
	List<Producto> productos = new ArrayList<Producto>();

	@BeforeEach
	void setUp() throws Exception {
		mercado = new MercadoCentral();
		caja = new Caja(mercado);
		detergente = new Producto("Magistral", 60);
		arroz = new ProductoCooperativa("Marolio", 30);
		
		// agrego los productos al stock del mercado
		mercado.addProducto(detergente);
		mercado.addProducto(arroz);
		
		// agrego los dos productos de prueba a la lista de compras
		productos.add(detergente);
		productos.add(arroz);
	}

	@Test
	void cobrarDetergenteOKTest() {
		caja.cobrarProducto(detergente);
		
		assertEquals(60, caja.getMontoACobrar());
	}
	
	@Test
	void registrarDosProductosTest() {		
		double monto = caja.registrarProductos(productos);
		
		assertEquals(87, monto);
	}
	
	@Test
	void registrarDeLaListaSoloElDetergenteTest() {		
		mercado.decrementarStockDe(arroz);
		double monto = caja.registrarProductos(productos);
		
		assertEquals(60, monto);
	}
	
	@Test
	void noHayStockDeNadaTest() {		
		mercado.decrementarStockDe(arroz);
		mercado.decrementarStockDe(detergente);
		double monto = caja.registrarProductos(productos);
		
		assertEquals(0, monto);
	}

}
