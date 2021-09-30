package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretariaDeportesTest {
	private SecretariaDeportes secretaria;
	private ActividadSemanal actividadUno;
	private ActividadSemanal actividadDos;
	private ActividadSemanal actividadTres;

	@BeforeEach
	void setUp() throws Exception {
		secretaria = new SecretariaDeportes();
		actividadUno = new ActividadSemanal(DiaDeLaSemana.LUNES, LocalTime.of(20, 00), Duration.ofHours(1l), Deporte.FUTBOL);
		actividadDos = new ActividadSemanal(DiaDeLaSemana.JUEVES, LocalTime.of(18, 30), Duration.ofHours(2l), Deporte.TENNIS);
		actividadTres = new ActividadSemanal(DiaDeLaSemana.DOMINGO, LocalTime.of(19, 00), Duration.ofHours(1l), Deporte.JABALINA);
		
		secretaria.agregarActividad(actividadUno);
		secretaria.agregarActividad(actividadDos);
		secretaria.agregarActividad(actividadTres);
	}

	@Test
	void testCalcularCostoActividadLunes() {
		double costoFutbol = secretaria.costoActividad(actividadUno);
		
		assertEquals(900, costoFutbol);
	}
	
	@Test
	void testCalcularCostoActividadJueves() {
		double costoTennis = secretaria.costoActividad(actividadDos);
		
		assertEquals(1600, costoTennis);
	}
	
	@Test
	void testCalcularCostoActividadDomingo() {
		double costoJabalina = secretaria.costoActividad(actividadTres);
		
		assertEquals(1800, costoJabalina);
	}

}
