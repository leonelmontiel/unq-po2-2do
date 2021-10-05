package ar.edu.unq.po2.tp6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretariaDeportes {
	
	private List<ActividadSemanal> actividades = new ArrayList<ActividadSemanal>();
	private Map<DiaDeLaSemana, Double> costosDias = new HashMap<DiaDeLaSemana, Double>();
	
	public SecretariaDeportes() {
		establecerCostoXDia();
	}
	
	public void establecerCostoXDia() {
		costosDias.put(DiaDeLaSemana.LUNES, 500.0);
		costosDias.put(DiaDeLaSemana.MARTES, 500.0);
		costosDias.put(DiaDeLaSemana.MIERCOLES, 500.0);
		costosDias.put(DiaDeLaSemana.JUEVES, 1000.0);
		costosDias.put(DiaDeLaSemana.VIERNES, 1000.0);
		costosDias.put(DiaDeLaSemana.SABADO, 1000.0);
		costosDias.put(DiaDeLaSemana.DOMINGO, 1000.0);
	}
	
	
	public double costoActividad(ActividadSemanal actividad) {
		return valorDelDia(actividad.getDia()) + totalCostoComplejidad(actividad);
	}

	private double totalCostoComplejidad(ActividadSemanal actividad) {
		return adicionalComplejidad() * actividad.getComplejidad();
	}

	private double adicionalComplejidad() {
		return 200;
	}

	private double valorDelDia(DiaDeLaSemana dia) {		
		return this.getCostosDia().get(dia);
	}

	private Map<DiaDeLaSemana, Double> getCostosDia() {
		return this.costosDias;
	}

	public void agregarActividad(ActividadSemanal actividad) {
		this.actividades.add(actividad);	
	}
	
	public List<ActividadSemanal> getActividadesDeFutbol() {
		List<ActividadSemanal> listaFutbol = actividades.stream().filter(actividad -> actividad.getDeporte() == Deporte.FUTBOL)
																	.toList();
		return listaFutbol;
	}

	public List<ActividadSemanal> getActividadesSegunComplejidad(int complejidad) {
		List<ActividadSemanal> listaSegunComplejidad = actividades.stream().filter(actividad -> actividad.getComplejidad() == complejidad)
																			.toList();
		return listaSegunComplejidad;
	}

	public long getTotalDuracionActividades() {
		Duration init = Duration.ofHours(0);
		Duration sum = actividades.stream().map(ActividadSemanal::getDuracion).reduce(init, (acum, a) -> {
							return acum.plus(a);
							});
		return sum.toHours();
	}

}