package ar.edu.unq.po2.tp6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;

public class SecretariaDeportes {
	
	private List<ActividadSemanal> actividades = new ArrayList<ActividadSemanal>();
	private Map<DiaDeLaSemana, Double> costosDias = new HashMap<DiaDeLaSemana, Double>();
	
	public SecretariaDeportes() {
		establecerCostoXDia();
	}
	
	private void establecerCostoXDia() {
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
	
	public List<ActividadSemanal> getActividadesDe_(Deporte deporte) {
		List<ActividadSemanal> listaDeporte = actividades.stream().filter(actividad -> actividad.getDeporte() == deporte)
																	.toList();
		return listaDeporte;
	}
	
	public List<DiaDeLaSemana> getDiasActividadesDe_(Deporte deporte) {
		List<DiaDeLaSemana> diasDeDeporte = getActividadesDe_(Deporte.FUTBOL).stream()
																				.map(actividad -> actividad.getDia())
																				.toList();
		return diasDeDeporte;
	}

	public List<ActividadSemanal> getActividadesSegunComplejidad_(int complejidad) {
		List<ActividadSemanal> listaSegunComplejidad = actividades.stream().filter(actividad -> actividad.getComplejidad() == complejidad)
																			.toList();
		return listaSegunComplejidad;
	}
	
	public List<DiaDeLaSemana> getDiasActividadesSegunComplejidad_(int complejidad) {
		List<DiaDeLaSemana> diasSegunComplejidad = getActividadesSegunComplejidad_(complejidad).stream()
																					.map(actividad -> actividad.getDia())
																					.toList();
		return diasSegunComplejidad;
	}

	public long getTotalDuracionActividades() {
		Duration init = Duration.ofHours(0);
		Duration sum = actividades.stream().map(ActividadSemanal::getDuracion).reduce(init, (acum, a) -> {
							return acum.plus(a);
							});
		return sum.toHours();
	}

	/*
	public ActividadSemanal getActividadMinCostoDeporte_(Deporte deporte) {
		// funcional pero súper horrible, no sé como hacer más simple la acción de devolver la ActividadSemanal con menor costo
		// porque al mappear la actividad a double, ya se pierde la referencia con la actividad misma. Tiene que existir alguna forma mucho más directa
		Double menorCostoAct = getActividadesDe_(deporte).stream().map(act -> costoActividad(act)).min(Comparator.naturalOrder()).get();
		ActividadSemanal actMenorCosto = getActividadesDe_(deporte).stream().filter(act -> costoActividad(act) == menorCostoAct).toList().get(0);
		
		return actMenorCosto;
	}*/
	
	public ActividadSemanal getActividadMenorCostoDeporte_(Deporte deporte) {
		// arriba está el código inicial que era feo, pero investigando como usar el comparing y como pasar un opcional a una entidad,
		// pude hacerlo más simple
		Optional<ActividadSemanal> menorCostoAct = getActividadesDe_(deporte).stream()
																			.min(Comparator.comparing((ActividadSemanal act) -> costoActividad(act)));
				
		return menorCostoAct.get();
	}
}