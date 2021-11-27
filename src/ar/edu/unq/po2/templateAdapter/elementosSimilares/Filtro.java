package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import java.util.List;

public abstract class Filtro {

	protected  List<WikipediaPage> getSimilarPages(WikipediaPage pagina, List<WikipediaPage> listaDePaginas) {
		List<WikipediaPage> paginasFiltradas = listaDePaginas.stream().filter(pag -> this.procesarHeuristica(pagina, pag)).toList();
		return paginasFiltradas;
	}

	protected abstract Boolean procesarHeuristica(WikipediaPage pagina, WikipediaPage otraPagina);

}
