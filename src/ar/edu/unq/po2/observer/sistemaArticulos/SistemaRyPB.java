package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaRyPB {

	private Map<LectorCientificoListener, Set<String>> suscriptores = new HashMap<LectorCientificoListener, Set<String>>();
	private Set<ArticuloCientifico> articulos = new HashSet<ArticuloCientifico>();;

	public void suscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().put(lector, lector.getIntereses());		
	}

	public Map<LectorCientificoListener, Set<String>> getSuscriptores() {
		return this.suscriptores;
	}

	public Boolean contieneA(LectorCientificoListener lector) {
		return this.getSuscriptores().containsKey(lector);
	}

	public void desuscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().remove(lector, lector.getIntereses());
	}

	public void cargarArticulo(ArticuloCientifico articulo) {
		this.getArticulos().add(articulo);		
		this.notificarNuevoArticulo(this, articulo);
	}

	public Set<ArticuloCientifico> getArticulos() {
		return this.articulos;
	}

	public Boolean contienePublicado(ArticuloCientifico articulo) {
		return this.getArticulos().contains(articulo);
	}

	public void notificarNuevoArticulo(SistemaRyPB sistema, ArticuloCientifico articuloWollok) {
		
	}

}
