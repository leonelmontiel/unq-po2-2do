package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartidoTest {

	private String resultadoEsperado;
	private Partido partido;
	private List<Contrincante> contrincantesEsperados;
	private Deporte deporteEsperado;
	private Contrincante contrincante;
	private Contrincante contrincanteDos;

	@BeforeEach
	void setUp() throws Exception {
		this.resultadoEsperado = "2-0";
		this.contrincantesEsperados = Arrays.asList(this.contrincante, this.contrincanteDos);
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
		List<Contrincante> contrincantesObtenidos = this.partido.getContrincantes();
		assertEquals(this.contrincantesEsperados, contrincantesObtenidos);
	}
	
	@Test
	void testGetDeporteFutbol() {
		Deporte deporteObtenido = this.partido.getDeporte();
		assertEquals(this.deporteEsperado, deporteObtenido);
	}


}
