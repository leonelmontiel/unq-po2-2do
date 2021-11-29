package ar.edu.unq.po2.refactoring.automotor;

import java.time.LocalDate;

public class RegistroAutomotor {

public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {

		// es un feature envy porque pide toda la informacion al colaborador externo que es el vehiculo
		/* LocalDate fechaFabricacion = vehiculo.getFechaFabricacion();
		Boolean esVehiculoPolicial = vehiculo.esVehiculoPolicial();
		String ciudadRadicacion = vehiculo.ciudadRadicacion();
		
		// vehiculos policiales no realizan vtv, ya que tienen otro tipo de control
		// sólo realizan vtv los vehículos con más de 1 anio de antiguedad y radicados
		// en 'Buenos Aires'
		return (!esVehiculoPolicial && fecha.minusYears(1).isAfter(fechaFabricacion)
				&& ciudadRadicacion.equalsIgnoreCase("Buenos Aires"));*/ 
	
		// lo que se tiene hacer es que el mismo vehiculo sepa si debe realizar o no la VTV, ya que no es responsabilidad
		// del registro automotor
		return vehiculo.debeRealizarVtv(fecha, "Buenos Aires");
	}
}
