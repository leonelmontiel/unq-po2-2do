package ar.edu.unq.po2.tp6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

public class SecretariaDeportes {
	
	private List<ActividadSemanal> actividades = new ArrayList<ActividadSemanal>();
	private Map<DiaDeLaSemana, Double> costosDias = new HashMap<DiaDeLaSemana, Double>();
	
	public SecretariaDeportes() {
		this.establecerCostoXDia();
	}
	
	private void establecerCostoXDia() {
		this.costosDias.put(DiaDeLaSemana.LUNES, 500.0);
		this.costosDias.put(DiaDeLaSemana.MARTES, 500.0);
		this.costosDias.put(DiaDeLaSemana.MIERCOLES, 500.0);
		this.costosDias.put(DiaDeLaSemana.JUEVES, 1000.0);
		this.costosDias.put(DiaDeLaSemana.VIERNES, 1000.0);
		this.costosDias.put(DiaDeLaSemana.SABADO, 1000.0);
		this.costosDias.put(DiaDeLaSemana.DOMINGO, 1000.0);
	}
	
	
	public double costoActividad(ActividadSemanal actividad) {
		return this.valorDelDia(actividad.getDia()) + this.totalCostoComplejidad(actividad);
	}

	private double totalCostoComplejidad(ActividadSemanal actividad) {
		return this.adicionalComplejidad() * actividad.getComplejidad();
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
		List<ActividadSemanal> listaDeporte = this.actividades.stream().filter(actividad -> actividad.getDeporte() == deporte)
																	.toList();
		return listaDeporte;
	}
	
	public List<DiaDeLaSemana> getDiasActividadesDe_(Deporte deporte) {
		List<DiaDeLaSemana> diasDeDeporte = this.getActividadesDe_(Deporte.FUTBOL).stream()
																				.map(actividad -> actividad.getDia())
																				.toList();
		return diasDeDeporte;
	}

	public List<ActividadSemanal> getActividadesSegunComplejidad_(int complejidad) {
		List<ActividadSemanal> listaSegunComplejidad = this.actividades.stream().filter(actividad -> actividad.getComplejidad() == complejidad)
																			.toList();
		return listaSegunComplejidad;
	}
	
	public List<DiaDeLaSemana> getDiasActividadesSegunComplejidad_(int complejidad) {
		List<DiaDeLaSemana> diasSegunComplejidad = this.getActividadesSegunComplejidad_(complejidad).stream()
																					.map(actividad -> actividad.getDia())
																					.toList();
		return diasSegunComplejidad;
	}

	public long getTotalDuracionActividades() {
		long init = 0;
		long sum = this.actividades.stream().map(ActividadSemanal::getDuracion).reduce(init, (acum, a) -> {
							return acum + a;
							});
		return sum;
	}

	/*
	public ActividadSemanal getActividadMinCostoDeporte_(Deporte deporte) {
		// funcional pero s?per horrible, no s? como hacer m?s simple la acci?n de devolver la ActividadSemanal con menor costo
		// porque al mappear la actividad a double, ya se pierde la referencia con la actividad misma. Tiene que existir alguna forma mucho m?s directa
		Double menorCostoAct = getActividadesDe_(deporte).stream().map(act -> costoActividad(act)).min(Comparator.naturalOrder()).get();
		ActividadSemanal actMenorCosto = getActividadesDe_(deporte).stream().filter(act -> costoActividad(act) == menorCostoAct).toList().get(0);
		
		return actMenorCosto;
	}*/
	
	public ActividadSemanal getActividadMenorCostoDeporte_(Deporte deporte) {
		// arriba est? el c?digo inicial que era feo, pero investigando como usar el comparing y como pasar un opcional a una entidad,
		// pude hacerlo m?s simple
		Optional<ActividadSemanal> menorCostoAct = this.getActividadesDe_(deporte).stream()
																			.min(Comparator.comparing((ActividadSemanal act) -> costoActividad(act)));
				
		return menorCostoAct.get();
	}

	/*
	// no s? en d?nde usar Collectors.groupingBy porque esto devuelve un Map<ObjetoA, List<ObjetoB> y el m?todo a implementar
	// debe devolver Map<Deporte, ActividadSemanal>, es decir, un deporte y su actividad semanal m?s econ?mica.
	public Map<Deporte, ActividadSemanal> getActMasEconomicaConDeporte_(Deporte deporte) {
		Map<Deporte, ActividadSemanal> actMasEconomica = new HashMap<Deporte, ActividadSemanal>();
		actMasEconomica.put(deporte, getActividadMenorCostoDeporte_(deporte));
		
		return actMasEconomica;
	}*/
	
	// no s? en d?nde usar Collectors.groupingBy porque esto devuelve un Map<ObjetoA, List<ObjetoB> y el m?todo a implementar
	// debe devolver Map<Deporte, ActividadSemanal>, es decir, un deporte y su actividad semanal m?s econ?mica.
	public Map<Deporte, ActividadSemanal> getActMasEconomicaConDeporte_() {
		Set<Deporte> deportes = this.actividades.stream().map(act -> act.getDeporte()).collect(Collectors.toSet());
		
		Map<Deporte, ActividadSemanal> actEconomicas = new HashMap<Deporte, ActividadSemanal>();
		deportes.forEach(dep -> actEconomicas.put(dep, getActividadMenorCostoDeporte_(dep)));
		
		return actEconomicas;
	}

	public void printAllActivities() {
		this.actividades.stream().forEach(act -> System.out.println(act.toString()));		
	}
}