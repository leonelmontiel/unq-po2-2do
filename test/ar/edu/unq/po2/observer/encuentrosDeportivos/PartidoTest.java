package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartidoTest {

	private String resultadoEsperado;
	private Partido partido;
	private List<String> contrincantesEsperados;
	private Deporte deporteEsperado;

	@BeforeEach
	void setUp() throws Exception {
		this.resultadoEsperado = "2-0";
		this.contrincantesEsperados = Arrays.asList("San Lorenzo", "Huracan");
		this.deporteEsperado = Deporte.FUTBOL;
		this.partido = new Partido(this.resultadoEsperado, this.contrincantesEsperados, this.deporteEsperado);
	}

	@Test
	void testGetResultado2a0() {
		String resultadoObtenido = this.partido.getResultado();
		assertEquals(this.resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	void testGetContrincantesSanLorenzoHuracan() {
		List<String> contrincantesObtenidos = this.partido.getContrincantes();
		assertEquals(this.contrincantesEsperados, contrincantesObtenidos);
	}
	
	@Test
	void testGetDeporteFutbol() {
		Deporte deporteObtenido = this.partido.getDeporte();
		assertEquals(this.deporteEsperado, deporteObtenido);
	}


}
