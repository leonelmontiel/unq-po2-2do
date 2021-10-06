package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretariaDeportesTest {
	private SecretariaDeportes secretaria;
	private ActividadSemanal actividadLunes;
	private ActividadSemanal actividadMartes;
	private ActividadSemanal actividadJueves;
	private ActividadSemanal actividadViernes;
	private ActividadSemanal actividadDomingo;

	@BeforeEach
	void setUp() throws Exception {
		secretaria = new SecretariaDeportes();
		actividadLunes = new ActividadSemanal(DiaDeLaSemana.LUNES, LocalTime.of(20, 00), Duration.ofHours(1), Deporte.FUTBOL);
		actividadMartes = new ActividadSemanal(DiaDeLaSemana.MARTES, LocalTime.of(20, 00), Duration.ofHours(2), Deporte.BASKET);
		actividadJueves = new ActividadSemanal(DiaDeLaSemana.JUEVES, LocalTime.of(18, 30), Duration.ofHours(2), Deporte.TENNIS);
		actividadViernes = new ActividadSemanal(DiaDeLaSemana.VIERNES, LocalTime.of(20, 00), Duration.ofHours(1), Deporte.FUTBOL);
		actividadDomingo = new ActividadSemanal(DiaDeLaSemana.DOMINGO, LocalTime.of(19, 00), Duration.ofHours(1), Deporte.JABALINA);
		
		
		
		secretaria.agregarActividad(actividadLunes);
		secretaria.agregarActividad(actividadMartes);
		secretaria.agregarActividad(actividadJueves);
		secretaria.agregarActividad(actividadViernes);
		secretaria.agregarActividad(actividadDomingo);
	}

	@Test
	void testCalcularCostoActividadLunes() {
		double costoFutbol = secretaria.costoActividad(actividadLunes);
		
		assertEquals(900, costoFutbol);
	}
	
	@Test
	void testCalcularCostoActividadMartes() {
		double costoBasket = secretaria.costoActividad(actividadMartes);
		
		assertEquals(900, costoBasket);
	}
	
	@Test
	void testCalcularCostoActividadJueves() {
		double costoTennis = secretaria.costoActividad(actividadJueves);
		
		assertEquals(1600, costoTennis);
	}
	
	@Test
	void testCalcularCostoActividadViernes() {
		double costoFutbol = secretaria.costoActividad(actividadViernes);
		
		assertEquals(1400, costoFutbol);
	}
	
	@Test
	void testCalcularCostoActividadDomingo() {
		double costoJabalina = secretaria.costoActividad(actividadDomingo);
		
		assertEquals(1800, costoJabalina);
	}
	
	///////////////////////
	
	@Test
	void testListaActividadesFutbol2Elementos() {
		// hacerlo genérico pasando un parámetro Enum DEPORTE
		List<ActividadSemanal> actividadesFutbol = secretaria.getActividadesDe_(Deporte.FUTBOL);
		
		assertEquals(2, actividadesFutbol.size());
	}
	
	@Test
	void testListaActividadesFutbolDias() {
		List<DiaDeLaSemana> diasDeFutbol = secretaria.getDiasActividadesDe_(Deporte.FUTBOL);
		
		
		assertTrue(diasDeFutbol.contains(DiaDeLaSemana.LUNES));
		assertTrue(diasDeFutbol.contains(DiaDeLaSemana.VIERNES));
	}
	
	@Test
	void testListaActividadesComplejidadDos3Elementos() {
		// en este test usamos la complejidad 2 que pertenece tanto a fútbol como a basket.
		List<ActividadSemanal> actividadesComplejidadDos = secretaria.getActividadesSegunComplejidad_(2);
		
		// se espera que la lista obtenida contenga 3 ActividadesSemanales 
		assertEquals(3, actividadesComplejidadDos.size());
	}
	
	@Test
	void testListaActividadesComplejidadDosDias() {
		// transformar esto en un método de Secretaría
		// con DiaDeLaSemana (LUNES, MARTES y VIERNES) con Deporte de complejidad 2 (FUTBOL y BASKET).
		List<DiaDeLaSemana> diasSegunComplejidad = secretaria.getDiasActividadesSegunComplejidad_(2);
		
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.LUNES));
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.MARTES));
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.VIERNES));
	}
	
	@Test
	void testCantidadDeHorasTotalesDeActividades() {
		long cantHorasActividades = 7;
		long horasObtenidas = secretaria.getTotalDuracionActividades();
		
		assertEquals(cantHorasActividades, horasObtenidas);
		;
	}
	
	///////////////////////
	
	/*
	@Test
	void testCostoMinDeFutbol() {
		ActividadSemanal actividadMenorCosto = secretaria.getActividadMinCostoDeporte_(Deporte.FUTBOL);
		
		// la actividad de fútbol los lunes cuesta $900, y los viernes $1400
		assertEquals(actividadLunes, actividadMenorCosto);
	}*/
	
	@Test
	void testCostoMenorDeFutbol() {
		ActividadSemanal actividadMenorCosto = secretaria.getActividadMenorCostoDeporte_(Deporte.FUTBOL);
		
		// la actividad de fútbol los lunes cuesta $900, y los viernes $1400
		assertEquals(actividadLunes, actividadMenorCosto);
	}
	
	@Test
	void testCostoMenorDeJabalina() {
		ActividadSemanal actividadMenorCosto = secretaria.getActividadMenorCostoDeporte_(Deporte.JABALINA);
		
		// la actividad de jabalina los domingo cuesta $1800, hay una sola actividad de jabalina registrada
		assertEquals(actividadDomingo, actividadMenorCosto);
	}
	
	///////////////////////
	
	@Test
	void testActMasEconomicaFutbol() {
		Map<Deporte, ActividadSemanal> actEsperada = new HashMap<Deporte, ActividadSemanal>();
		actEsperada.put(Deporte.FUTBOL, actividadLunes);
		
		Map<Deporte, ActividadSemanal> actFutEconomica = secretaria.getActMasEconomicaConDeporte_(Deporte.FUTBOL);		
		
		assertEquals(actEsperada, actFutEconomica);
	}
	
	//////////////////////
	
	@Test
	void testToStringActMartes() {
		String stringEsperado = "Deporte: BASKET. Día: MARTES a las: 20:00. Duración: 2 hora(s)";
		String impresion = actividadMartes.toString();
		
		assertEquals(stringEsperado, impresion);
	}
	
	@Test
	void testToStringActDomingo() {
		String stringEsperado = "Deporte: JABALINA. Día: DOMINGO a las: 19:00. Duración: 1 hora(s)";
		String impresion = actividadDomingo.toString();
		
		assertEquals(stringEsperado, impresion);
	}
	
}
