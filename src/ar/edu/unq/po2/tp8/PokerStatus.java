package ar.edu.unq.po2.tp8;

import java.util.Arrays;
import java.util.List;

public class PokerStatus {

	public boolean verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		//this.verificarQueNoHayaIdenticas(cartas);
		
		//devuelve una lista con las cartas únicas sin sus duplicadas, si hay una carta que no se duplica la devuelve también
		List<String> sinDuplicadas = this.cartasSoloConValores(cartas).stream().distinct().toList();
		
		// se compara con 2 porque 3 elementos son los que se repiten, y se debe tener en cuenta el cuarto que es el original
		boolean hayPoker = sinDuplicadas.size() == 2;
		return hayPoker;
	}

	public List<String> cartasSoloConValores(List<String> cartas) {
		List<String> valores = cartas.stream().map(c -> c.replaceFirst(".$","")).toList();		
	    return valores;
	}

}
