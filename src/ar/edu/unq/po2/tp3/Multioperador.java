package ar.edu.unq.po2.tp3;

public class Multioperador {
	private int[] arregloEnteros;
		
	void addArregloEnteros(int[] arreglo) {
		arregloEnteros = arreglo;
	}
	
	Integer addAll() {
		int add = 0;
		
		for (int i=0; i < arregloEnteros.length; i++) {
			add += arregloEnteros[i];
		}
		
		return add;
	}

	public Integer restAll() {
		int rest = arregloEnteros[0]; //lo inicializo con el primer valor para que pueda restarse con el siguiente, si lo inicializara con 0
									//el valor quedaría opuesto.		
		for (int i=1; i < arregloEnteros.length; i++) {
			rest -= arregloEnteros[i];
		}
		
		return rest;
	}

	public Integer multiplyAll() {
		int mult = arregloEnteros[0]; //lo inicializo con el primer valor porque si lo hago con 0 el resultado sería 0
		
		for (int i=1; i < arregloEnteros.length; i++) {
			mult *= arregloEnteros[i];
		}
		
		return mult;
	}
	
}
