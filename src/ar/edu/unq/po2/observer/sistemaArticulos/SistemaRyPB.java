package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.HashSet;
import java.util.Set;

public class SistemaRyPB {

	private Set<LectorCientificoListener> suscriptores = new HashSet<LectorCientificoListener>();
	private Set<ArticuloCientifico> articulos = new HashSet<ArticuloCientifico>();;

	public void suscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().add(lector);		
	}

	public Set<LectorCientificoListener> getSuscriptores() {
		return this.suscriptores ;
	}

	public Boolean contieneA(LectorCientificoListener lector) {
		return this.getSuscriptores().contains(lector);
	}

	public void desuscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().remove(lector);
	}

	public void cargarArticulo(ArticuloCientifico articulo) {
		this.getArticulos().add(articulo);		
	}

	public Set<ArticuloCientifico> getArticulos() {
		return this.articulos;
	}

	public Boolean contienePublicado(ArticuloCientifico articulo) {
		return this.getArticulos().contains(articulo);
	}

}
