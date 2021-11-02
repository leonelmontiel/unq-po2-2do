package ar.edu.unq.po2.composite.carroDeCompras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarroDeCompreasTest {

	private CarroDeCompras carro;
	private Product arroz = mock(Product.class);
	private Product leche = mock(Product.class);
	private Product queso = mock(Product.class);

	@BeforeEach
	void setUp() throws Exception {
		this.carro = new CarroDeCompras();
	}

	@Test
	void testGetElements() {
		//SetUp		
		List<Product> listaEsperada = Arrays.asList(this.arroz, this.leche, this.queso);
		//Excercise
		this.carro.agregar(this.arroz); this.carro.agregar(this.leche); this.carro.agregar(this.queso);
		List<Product> listaObtenida = this.carro.getElements();
		assertEquals(listaEsperada , listaObtenida);
	}

}
