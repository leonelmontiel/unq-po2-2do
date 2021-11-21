package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaRyPB {

	private Set<LectorCientificoListener> suscriptores = new HashSet<LectorCientificoListener>();
	private Set<ArticuloCientifico> articulos = new HashSet<ArticuloCientifico>();;

	public void suscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().put(lector, lector.getIntereses());		
	}

	public Set<LectorCientificoListener> getSuscriptores() {
		return this.suscriptores;
	}

	public Boolean contieneA(LectorCientificoListener lector) {
		return this.getSuscriptores().contains(lector);
	}

	public void desuscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().remove(lector);
	}

	public void cargarArticulo(ArticuloCientifico articulo) {
		this.getArticulos().add(articulo);		
		this.notificarNuevoArticulo(articulo);
	}

	public Set<ArticuloCientifico> getArticulos() {
		return this.articulos;
	}

	public Boolean contienePublicado(ArticuloCientifico articulo) {
		return this.getArticulos().contains(articulo);
	}

	public void notificarNuevoArticulo(ArticuloCientifico articulo) {
		this.getSuscriptores().stream().forEach(lector -> this.notificarArticuloSiEstaInteresado(lector, articulo));
	}

	private void notificarArticuloSiEstaInteresado(LectorCientificoListener lector, ArticuloCientifico articulo) {
		if (lector.estaInteresadoEnAlgunaPalabraDe(articulo.getPalabrasClaves())) {
			lector.recibirNuevoArticulo(this, articulo);
		}
	}

}
