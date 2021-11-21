package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.HashSet;
import java.util.Set;

public class SistemaRyPB {
	
	/**
	 *
	 * @author Leonel Montiel
	 * @version 1.0
	 *
	 * Utilicé el patrón Observer para que las clases que implementen la interfaz LectorCientificoListener reciban nuevos artículos según
	 * sus intereses. Opté por la estrategia de Observer con Listener para que, justamente, reciban los aspectos que cambiaron en el sistema y de
	 * los cuáles estén interesados. Y en adición, opté por esto para que los listeners se suscriban a más de un sistema.
	 * 
	 * ROLES:
	 *  - Observable -> SistemaRyPB
	 *  - Observador -> LectorCientificoListener
	 * 
	 */

	private Set<LectorCientificoListener> suscriptores = new HashSet<LectorCientificoListener>();
	private Set<ArticuloCientifico> articulos = new HashSet<ArticuloCientifico>();;

	public void suscribirA(LectorCientificoListener lector) {
		this.getSuscriptores().add(lector);		
	}

	public Set<LectorCientificoListener> getSuscriptores() {
		return this.suscriptores;
	}

	Boolean contieneA(LectorCientificoListener lector) {
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

	Boolean contienePublicado(ArticuloCientifico articulo) {
		return this.getArticulos().contains(articulo);
	}

	void notificarNuevoArticulo(ArticuloCientifico articulo) {
		this.getSuscriptores().stream().forEach(lector -> this.notificarArticuloSiEstaInteresado(lector, articulo));
	}

	private void notificarArticuloSiEstaInteresado(LectorCientificoListener lector, ArticuloCientifico articulo) {
		if (esta_InteresadoEn_(lector, articulo)) {
			lector.recibirNuevoArticulo(this, articulo);
		}
	}

	private Boolean esta_InteresadoEn_(LectorCientificoListener lector, ArticuloCientifico articulo) {
		return lector.estaInteresadoEnAlgunaPalabraDe(articulo.getPalabrasClaves());
	}

}
