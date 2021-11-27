package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FiltroTest {

	protected Filtro filtro;
	protected WikipediaPage pagina;
	protected List<WikipediaPage> listaDePaginas;
	protected List<WikipediaPage> paginasFiltradasDeseadas;
	protected WikipediaPage paginaA;
	protected WikipediaPage paginaB;
	protected WikipediaPage paginaC;

	@Test
	void testFiltroAplicadoOK() {
		//exercise
		List<WikipediaPage> paginasFiltradas = this.filtro.getSimilarPages(this.pagina, this.listaDePaginas);
		//verify
		assertEquals(this.paginasFiltradasDeseadas, paginasFiltradas);
	}

}
