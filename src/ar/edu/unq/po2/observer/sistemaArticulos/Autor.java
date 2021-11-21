package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.HashSet;
import java.util.Set;

public class Autor {

	private Set<String> filiaciones = new HashSet<String>();

	public Set<String> getFiliaciones() {
		return this.filiaciones ;
	}

}
