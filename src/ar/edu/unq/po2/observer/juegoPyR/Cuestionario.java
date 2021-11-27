package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Map;
import java.util.Set;

public class Cuestionario {

	private Map<String, String> cuestionario;

	public Set<String> getPreguntas() {
		
		return this.cuestionario.keySet();
	}

}
