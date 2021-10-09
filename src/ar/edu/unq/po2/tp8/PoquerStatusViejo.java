package ar.edu.unq.po2.tp8;

import java.util.ArrayList;
import java.util.List;

public class PoquerStatusViejo {

	public String verificar(Carta cartaUno, Carta cartaDos, Carta cartaTres, Carta cartaCuatro,
			Carta cartaCinco) {
		// Guarda en una variable una lista con las cartas pasadas por par�metro
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(cartaUno);  cartas.add(cartaDos);   cartas.add(cartaTres);   cartas.add(cartaCuatro);   cartas.add(cartaCinco);
		
		return hayAlgunJuego(cartas);
	}
	
	// Eval�a si se da alguno de los juego (P�quer, Tr�o o Color), si no se da un juego, retorna "Nada"
		public String hayAlgunJuego(List<Carta> cartas) {
			if(this.hayPoquer(cartas)) {return "P�quer";} 
			if(this.hayTrio(cartas)) {return "Tr�o";}
			if(this.hayColor(cartas)) {return "Color";}
			return "Nada";
		}
		
	/*
	 * A PARTIR DE AC� USO MENSAJES DE LA API STREAM, PARA FILTRAR, CONTAR Y MATCHEAR
	 */
		
	// Evalua cada valor de la lista de cartas, y si ese valor se repite cuatro veces en la lista entonces hay p�quer
	public boolean hayPoquer(List<Carta> cartas) {
		return cartas.stream().anyMatch(carta -> contarRepeticionesDeUnValor(carta.getValor(), cartas) == 4);
	}
	
	// hace lo mismo que en "hayPoquer" pero eval�a si hay 3 valores iguales
	public boolean hayTrio(List<Carta> cartas) {
		return cartas.stream().anyMatch(carta -> contarRepeticionesDeUnValor(carta.getValor(), cartas) == 3);
	}
	
	// convierte la lista de cartas en una nueva lista con sus palos, y a partir de ella itera y cuenta si el palo de la primera se repite 5 veces
	// en la lista de palos generada
	public boolean hayColor(List<Carta> cartas) {
		return cartas.stream().anyMatch(carta -> contarRepeticionesDeUnPalo(carta.getPalo(), cartas) == 5);
	}
	
	// Filtra las cartas que tienen un valor dado por par�metro, y las cuenta
	public long contarRepeticionesDeUnValor(int valor, List<Carta> cartas){
		
	    long rep  = cartas.stream()
	                      .filter(carta -> carta.getValor() == valor)
	                      .count();
	    return rep;
	}
	
	// Filtra las cartas que tienen un palo dado por par�metro, y las cuenta
	public long contarRepeticionesDeUnPalo(String palo, List<Carta> cartas){
		
	    long rep  = cartas.stream()
	                      .filter(carta -> carta.getPalo().equals(palo))
	                      .count();
	    return rep;
	}
	
	
	
	
	/* M�TODO �TILES HASTA EL PUNTO 3 DONDE SE TRABAJABA CON STRINGS
	// retorna una nueva lista pero sin el �ltimo car�cter de cada String que representa el palo de una carta
	public List<String> cartasSoloConValores(List<String> cartas) {
		List<String> valores = new ArrayList<String>();
		for (String carta: cartas) {
			String valor = carta.replaceFirst(".$","");
			valores.add(valor);
		}
		
	    return valores;
	}
	
	// retorna una nueva lista pero con el �ltimo car�cter de cada String que representa el palo de una carta
	public List<String> cartasSoloConPalos(List<String> cartas) {
		List<String> palos = new ArrayList<String>();
		for (String carta: cartas) {
			String palo = carta.substring(carta.length() - 1);
			palos.add(palo);
		}
		
	    return palos;
	}
	 */
}
