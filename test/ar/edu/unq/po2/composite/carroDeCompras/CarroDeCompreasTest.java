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
		
		//Config Mocks
		when((this.arroz).getPrice()).thenReturn(60f);
		when((this.leche).getPrice()).thenReturn(90f);
		when((this.queso).getPrice()).thenReturn(400f);
		
		this.carro.agregar(arroz);
		this.carro.agregar(leche);
		this.carro.agregar(queso);
	}

	@Test
	void testGetElements() {
		//SetUp		
		List<Product> listaEsperada = Arrays.asList(arroz, leche, queso);
		//Excercise
		List<Product> listaObtenida = this.carro.getElements();
		//verify
		assertEquals(listaEsperada , listaObtenida);
	}
	
	@Test
	void testTotalRoundedEs550Pesos() {
		//Excercise
		Float total = this.carro.totalRounded();
		//Verify
		assertEquals(550f, total);
		verify(this.arroz).getPrice(); verify(this.leche).getPrice(); verify(this.queso).getPrice();
	}

}
