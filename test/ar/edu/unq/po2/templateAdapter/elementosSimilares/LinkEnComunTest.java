package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

class LinkEnComunTest extends FiltroTest{

	@BeforeEach
	void setUp() throws Exception {
		//setUp
		this.pagina = mock(WikipediaPage.class);
		when(this.pagina.getLinks()).thenReturn(Arrays.asList(this.paginaA, this.paginaB));
		this.paginaA = mock(WikipediaPage.class);
		when(this.paginaA.getLinks()).thenReturn(Arrays.asList(this.paginaC, this.paginaB));
		this.paginaB = mock(WikipediaPage.class);
		when(this.paginaB.getLinks()).thenReturn(Arrays.asList(this.paginaC, this.paginaB));
		this.paginaC = mock(WikipediaPage.class);
		when(this.paginaC.getLinks()).thenReturn(Arrays.asList(this.paginaA));
		
		this.filtro = new LinkEnComun();
		this.listaDePaginas = Arrays.asList(this.paginaA, this.paginaB, this.paginaC);
		this.paginasFiltradasDeseadas = Arrays.asList(this.paginaA, this.paginaB);
	}

}
