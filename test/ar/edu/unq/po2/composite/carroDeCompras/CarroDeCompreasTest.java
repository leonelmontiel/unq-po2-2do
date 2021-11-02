package ar.edu.unq.po2.composite.carroDeCompras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarroDeCompreasTest {

	private CarroDeCompras carro;//SUT
	private Product arroz = mock(Product.class);//DOC
	private Product leche = mock(Product.class);//DOC
	private Product queso = mock(Product.class);//DOC

	@BeforeEach
	void setUp() throws Exception {
		this.carro = new CarroDeCompras();
		
		//Config Mocks
		when((this.arroz).getPrice()).thenReturn(60.65f);
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
	void testTotalEs550PesosCon65() {
		//Excercise
		Float total = this.carro.total();
		//Verify
		assertEquals(550.65f, total);
		verify(this.arroz).getPrice(); verify(this.leche).getPrice(); verify(this.queso).getPrice();
	}
	
	@Test
	void testTotalRoundedNODaRedondeadoA551() {
		//Excercise
		Float total = this.carro.total();
		//Verify
		assertNotEquals(551f, total);
		verify(this.arroz).getPrice(); verify(this.leche).getPrice(); verify(this.queso).getPrice();
	}
	
	@Test
	void testTotalRoundedEs551Pesos() {
		//Excercise
		int total = this.carro.totalRounded();
		//Verify
		assertEquals(551, total);
		verify(this.arroz).getPrice(); verify(this.leche).getPrice(); verify(this.queso).getPrice();
	}
	
	@Test
	void testTotalRoundedNOEs550Pesos() {
		//Excercise
		int total = this.carro.totalRounded();
		//Verify
		assertNotEquals(550, total);
		verify(this.arroz).getPrice(); verify(this.leche).getPrice(); verify(this.queso).getPrice();
	}

}
