package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {

	private List<Ingreso> ingresos = new ArrayList<Ingreso>();
	
	public void agregarIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
	}

	public double getTotalPercibido() {
		double total = ingresos.stream().mapToDouble(i -> i.getMonto())
										.sum();
		return total;
	}

	public double getMontoImponible() {
		double total = ingresos.stream().mapToDouble(i -> i.getMontoImponible())
										.sum();
		return total;
	}

	public double getImpuestoAPagar() {
		// el impuesto a pagar es un 2% del monto imponible
		// intenté hacer "double porcentaje = 2 / 100" para multiplicar este resultado en el return, pero retorna 0 así
		return getMontoImponible() * 2 / 100;
	}
	
	
	

}
	
