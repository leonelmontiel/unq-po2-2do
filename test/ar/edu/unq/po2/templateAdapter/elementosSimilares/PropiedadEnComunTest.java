package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadEnComunTest extends FiltroTest{

	@BeforeEach
	void setUp() throws Exception {
		this.pagina = mock(WikipediaPage.class);
		Map<String, WikipediaPage> claveValor = new HashMap<String, WikipediaPage>();
		claveValor.put("Nombre", this.paginaA);
		when(this.pagina.getInfobox()).thenReturn(claveValor);
		
		this.paginaA = mock(WikipediaPage.class);
		Map<String, WikipediaPage> claveValorA = new HashMap<String, WikipediaPage>();	
		claveValorA.put("Direccion", this.pagina);
		when(this.paginaA.getInfobox()).thenReturn(claveValorA);
		
		this.paginaB = mock(WikipediaPage.class);
		Map<String, WikipediaPage> claveValorB = new HashMap<String, WikipediaPage>();
		claveValorB.put("Nombre", this.paginaC);
		when(this.paginaB.getInfobox()).thenReturn(claveValorB);
		
		this.paginaC = mock(WikipediaPage.class);
		Map<String, WikipediaPage> claveValorC = new HashMap<String, WikipediaPage>();
		claveValorC.put("Nombre", this.pagina);
		when(this.paginaC.getInfobox()).thenReturn(claveValorC);
		
		this.filtro = new PropiedadEnComun();
		this.listaDePaginas = Arrays.asList(this.paginaA, this.paginaB, this.paginaC);
		this.paginasFiltradasDeseadas = Arrays.asList(this.paginaB, this.paginaC);
	}
	
	@Test
	void verifyTestFiltradoAplicadoOK() {
		this.testFiltroAplicadoOK();
		verify(this.pagina, times(3)).getInfobox(); //la lista de páginas contiene 3 elementos, llama a getInfobox por cada elemento
		//llama a getInfobox de las páginas de la lista dada por parámetro solo una vez para conocer su contenido y luego evaluar sus claves
		verify(this.paginaA).getInfobox();
		verify(this.paginaB).getInfobox();
		verify(this.paginaC).getInfobox();
	}

}
