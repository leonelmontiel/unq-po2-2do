package ar.edu.unq.po2.refactoring.automotor;

import java.time.LocalDate;

public class Vehiculo {
	
	/* 
	 * la versión oroginal de esta clase indica que es una data class, ya que solo provee información más no comportamiento.
	 * También se ve que al hacer referencia a las variables de instancia no se utiliza el prefijo "this."
	 */
	
	private Boolean esVehiculoPolicial;
	private LocalDate fechaFabricacion;	
	private String ciudadRadicacion; 
	
	public Vehiculo(Boolean esVehiculoPolicial, LocalDate fechaFabricacion, String ciudadRadicacion) {
		this.esVehiculoPolicial = esVehiculoPolicial;
		this.fechaFabricacion = fechaFabricacion;
		this.ciudadRadicacion = ciudadRadicacion;
	}

	public Boolean esVehiculoPolicial() {
		return this.esVehiculoPolicial;
	}

	public LocalDate getFechaFabricacion() {
		return this.fechaFabricacion;
	}

	public String ciudadRadicacion() {
		return this.ciudadRadicacion;
	}

	//metodo que agrega comportamiento a la clase 
	public Boolean debeRealizarVtv(LocalDate fecha, String nombreCiudad) {
		return !this.esVehiculoPolicial && tieneAntiguedadMayorA(1, fecha) && 
				this.estaRadicadoEn(nombreCiudad);
	}

	//operación concreta que pregunta si esta radicado en en la ciudad dada por parámetro
	public boolean estaRadicadoEn(String nombreCiudad) {
		return this.ciudadRadicacion.equalsIgnoreCase(nombreCiudad);
	}

	//operación concreta que pregunta si la antiguedad del auto es mayor a un año
	private Boolean tieneAntiguedadMayorA(int cantidadAños, LocalDate fecha) {
		return fecha.minusYears(cantidadAños).isAfter(this.fechaFabricacion);
	}
}
