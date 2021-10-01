package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

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
		actividadLunes = new ActividadSemanal(DiaDeLaSemana.LUNES, LocalTime.of(20, 00), Duration.ofHours(1l), Deporte.FUTBOL);
		actividadMartes = new ActividadSemanal(DiaDeLaSemana.MARTES, LocalTime.of(20, 00), Duration.ofHours(2l), Deporte.BASKET);
		actividadJueves = new ActividadSemanal(DiaDeLaSemana.JUEVES, LocalTime.of(18, 30), Duration.ofHours(2l), Deporte.TENNIS);
		actividadViernes = new ActividadSemanal(DiaDeLaSemana.VIERNES, LocalTime.of(20, 00), Duration.ofHours(1l), Deporte.FUTBOL);
		actividadDomingo = new ActividadSemanal(DiaDeLaSemana.DOMINGO, LocalTime.of(19, 00), Duration.ofHours(1l), Deporte.JABALINA);
		
		
		
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
	
	@Test
	void testListaActividadesFutbol2Elementos() {
		List<ActividadSemanal> actividadesFutbol = secretaria.getActividadesDeFutbol();
		
		assertEquals(2, actividadesFutbol.size());
	}
	
	@Test
	void testListaActividadesFutbolDias() {
		List<DiaDeLaSemana> diasDeFutbol = secretaria.getActividadesDeFutbol().stream()
																				.map(actividad -> actividad.getDia())
																				.toList();
		
		assertTrue(diasDeFutbol.contains(DiaDeLaSemana.LUNES));
		assertTrue(diasDeFutbol.contains(DiaDeLaSemana.VIERNES));
	}
	
	@Test
	void testListaActividadesComplejidadDos3Elementos() {
		// en este test usamos la complejidad 2 que pertenece tanto a fútbol como a basket.
		List<ActividadSemanal> actividadesComplejidadDos = secretaria.getActividadesSegunComplejidad(2);
		
		// se espera que la lista obtenida contenga 3 DiaDeLaSemana (LUNES, MARTES y VIERNES) con Deporte de complejidad 2 (FUTBOL y BASKET).
		assertEquals(3, actividadesComplejidadDos.size());
	}
	
	@Test
	void testListaActividadesComplejidadDosDias() {
		List<DiaDeLaSemana> diasSegunComplejidad = secretaria.getActividadesSegunComplejidad(2).stream()
																								.map(actividad -> actividad.getDia())
																								.toList();
		
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.LUNES));
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.MARTES));
		assertTrue(diasSegunComplejidad.contains(DiaDeLaSemana.VIERNES));
	}

}
