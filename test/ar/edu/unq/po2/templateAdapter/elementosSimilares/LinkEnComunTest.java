package ar.edu.unq.po2.templateAdapter.elementosSimilares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkEnComunTest extends FiltroTest{

	@BeforeEach
	void setUp() throws Exception {
		this.filtro = new LinkEnComun();
		this.listaDePaginas = Arrays.asList(this.paginaA, this.paginaB, this.paginaC);
		this.paginasFiltradasDeseadas = Arrays.asList(this.paginaA, this.paginaC);
	}

}
