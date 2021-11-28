package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import java.util.Set;

public class PropiedadEnComun extends Filtro{

	@Override
	protected Boolean procesarHeuristica(WikipediaPage pagina, WikipediaPage otraPagina) {
		return this.compartenPropiedades(pagina, otraPagina);
	}

	private Boolean compartenPropiedades(WikipediaPage pagina, WikipediaPage otraPagina) {
		return this.propiedadesDe(pagina).stream().anyMatch(propiedad -> this.contienePropiedad(otraPagina, propiedad));
	}

	private Set<String> propiedadesDe(WikipediaPage pagina) {
		return pagina.getInfobox().keySet();
	}

	private Boolean contienePropiedad(WikipediaPage pagina, String propiedad) {
		return pagina.getInfobox().containsKey(propiedad);
	}

}
