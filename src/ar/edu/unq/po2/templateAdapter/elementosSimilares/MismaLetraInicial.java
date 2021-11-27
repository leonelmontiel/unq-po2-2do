package ar.edu.unq.po2.templateAdapter.elementosSimilares;

public class MismaLetraInicial extends Filtro {

	@Override
	protected Boolean procesarHeuristica(WikipediaPage pagina, WikipediaPage otraPagina) {
		return this.tienenMismaInicial(pagina, otraPagina);
	}
	
	private Boolean tienenMismaInicial(WikipediaPage pagina, WikipediaPage otraPagina) {
		return this.inicialEnTituloDe(pagina) == this.inicialEnTituloDe(otraPagina);
	}

	private char inicialEnTituloDe(WikipediaPage pagina) {
		return pagina.getTitle().charAt(0);
	}


}
