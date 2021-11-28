package ar.edu.unq.po2.templateAdapter.elementosSimilares;

public class LinkEnComun extends Filtro {

	@Override
	protected Boolean procesarHeuristica(WikipediaPage pagina, WikipediaPage otraPagina) {		
		return this.compartenLinks(pagina, otraPagina);
	}

	private Boolean compartenLinks(WikipediaPage pagina, WikipediaPage otraPagina) {
		// toma las p�ginas que comparten al menos un link con la p�gina dada por par�metro
		return pagina.getLinks().stream().anyMatch(link -> this.linkEstaEn(link, otraPagina));
	}

	private Boolean linkEstaEn(WikipediaPage link, WikipediaPage otraPagina) {
		return otraPagina.getLinks().contains(link);
	}

}
