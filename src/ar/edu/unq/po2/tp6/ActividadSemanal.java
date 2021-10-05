package ar.edu.unq.po2.tp6;

import java.time.Duration;
import java.time.LocalTime;

public class ActividadSemanal {
	private DiaDeLaSemana diaDeLaSemana;
	private LocalTime hora;
	private Duration duracion;
	private Deporte deporte;
	
	public ActividadSemanal(DiaDeLaSemana dia, LocalTime hora, Duration duracion, Deporte deporte) {
		this.diaDeLaSemana = dia;
		this.hora = hora;
		this.duracion = duracion;
		this.deporte = deporte;
	}
	
	public Deporte getDeporte() {
		return this.deporte;
	}
	
	public Integer getComplejidad() {
		return this.getDeporte().getComplejidad();
	}

	public DiaDeLaSemana getDia() {
		return this.diaDeLaSemana;
	}

	public Duration getDuracion() {
		return this.duracion;
	}
}
