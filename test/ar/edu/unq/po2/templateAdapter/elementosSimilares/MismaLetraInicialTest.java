package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

class MismaLetraInicialTest extends FiltroTest{

	@BeforeEach
	void setUp() throws Exception {
		/* setUp Mocks */
		// setUp getTitle
		this.pagina = mock(WikipediaPage.class);
		when(this.pagina.getTitle()).thenReturn("Leonel Montiel");
		this.paginaA = mock(WikipediaPage.class);
		when(this.paginaA.getTitle()).thenReturn("La Plata");
		this.paginaB = mock(WikipediaPage.class);
		when(this.paginaB.getTitle()).thenReturn("Shrek 2");
		this.paginaC = mock(WikipediaPage.class);
		when(this.paginaC.getTitle()).thenReturn("Lobo");
		
		this.filtro = new MismaLetraInicial();		
		this.listaDePaginas = Arrays.asList(this.paginaA, this.paginaB, this.paginaC);
		this.paginasFiltradasDeseadas = Arrays.asList(this.paginaA, this.paginaC);
	}

}
