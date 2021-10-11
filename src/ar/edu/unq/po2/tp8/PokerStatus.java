package ar.edu.unq.po2.tp8;

import java.util.Arrays;
import java.util.List;

public class PokerStatus {

	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		List<Carta> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		//this.verificarQueNoHayaIdenticas(cartas);
		
		if(this.hayPoquer(cartas)) {return "Póquer";} 
		if(this.hayTrio(cartas)) {return "Trío";}
		if(this.hayColor(cartas)) {return "Color";}
		return "Nada";
	}

	/////////////////

	public boolean hayPoquer(List<Carta> cartas) {
		return cantValoresEquivaleA(this.cartasSoloConValores(cartas), 4);
	}
	
	public boolean hayTrio(List<Carta> cartas) {
		return cantValoresEquivaleA(this.cartasSoloConValores(cartas), 3);
	}
	
	public boolean hayColor(List<Carta> cartas) {
		return cantPalosEquivaleA(this.cartasSoloConPalos(cartas), 5);
	}
	
	//////////////// INTENTÉ QUE EL VALOR Y EL PALO IMPLEMENTARAN UNA INTERFACE PARA HACER GENÉRICOS LOS MENSAJES DONDE SE COMPARA LA CANTIDAD DE REPETIDOS
	// PERO CUANDO INTENTO GUARDAR CUALQUIERA DE LOS ENUM EN UNA LISTA DE LA INTERFACE, ME DICE QUE NO ES POSIBLE
	
	public List<Valor> cartasSoloConValores(List<Carta> cartas) {
		List<Valor> valores = cartas.stream().map(c -> c.getValor()).toList();		
	    return valores;
	}

	public boolean cantValoresEquivaleA(List<Valor> valores, int num) {
		return valores.stream().anyMatch(valor -> contarRepeticionesDeValor(valor, valores) == num);
	}

	public long contarRepeticionesDeValor(Valor valor, List<Valor> valores) {
		long rep  = valores.stream()
                .filter(v -> v == valor)
                .count();
		return rep;
	}
	
	////////////////
	
	public boolean cantPalosEquivaleA(List<Palo> palos, int num) {
		return palos.stream().anyMatch(palo -> contarRepeticionesDePalos(palo, palos) == num);
	}

	public List<Palo> cartasSoloConPalos(List<Carta> cartas) {
		List<Palo> palos = cartas.stream().map(c -> c.getPalo()).toList();		
	    return palos;
	}
	
	public long contarRepeticionesDePalos(Palo palo, List<Palo> palos) {
		long rep  = palos.stream()
                .filter(p -> p == palo)
                .count();
		return rep;
	}

	

	

	/* VERIFICAR VIEJO
	public boolean verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		//this.verificarQueNoHayaIdenticas(cartas);
		
		return this.hayPoquer(cartas);
	}
	
	VERIFICAR CON LAS POSIBLES JUGADAS (STRINGS)
	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {	
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		//this.verificarQueNoHayaIdenticas(cartas);
		
		if(this.hayPoquer(cartas)) {return "Póquer";} 
		if(this.hayTrio(cartas)) {return "Trío";}
		if(this.hayColor(cartas)) {return "Color";}
		return "Nada";
	}

	///////////////////////
	public List<String> cartasSoloConValores(List<String> cartas) {
		List<String> valores = cartas.stream().map(c -> c.replaceFirst(".$","")).toList();		
	    return valores;
	}
	
	public List<String> cartasSoloConPalos(List<String> cartas) {
		List<String> valores = cartas.stream().map(c -> c.substring(c.length() - 1)).toList();		
	    return valores;
	}
	
	///////////////////////		
	// Evalua cada carta de la lista de String, y si su valor se repite cuatro veces en la lista entonces hay póquer
	public boolean hayPoquer(List<String> cartas) {
		return cantCadenaEquivaleA(this.cartasSoloConValores(cartas), 4);
	}
	
	// hace lo mismo que en "hayPoquer" pero evalúa si hay 3 valores iguales
	public boolean hayTrio(List<String> cartas) {
		return cantCadenaEquivaleA(this.cartasSoloConValores(cartas), 3);
	}
	
	// convierte la lista de String en una nueva lista con la representación de los palos, y a partir de ella itera y cuenta si el palo de la primera se
	// repite 5 veces en la lista de palos generada
	public boolean hayColor(List<String> cartas) {
		return cantCadenaEquivaleA(this.cartasSoloConPalos(cartas), 5);
	}

	/////////////////////
	public boolean cantCadenaEquivaleA(List<String> cartas, int valor) {
		return cartas.stream().anyMatch(carta -> contarRepeticiones(carta, cartas) == valor);
	}
	
	// cuenta el total de cadenas que son iguales a otra dada por parámetro
	public long contarRepeticiones(String cadena, List<String> cadenas){
		
	    long rep  = cadenas.stream()
	                      .filter(c -> c.equals(cadena))
	                      .count();
	    return rep;
	}*/
	
	

}
