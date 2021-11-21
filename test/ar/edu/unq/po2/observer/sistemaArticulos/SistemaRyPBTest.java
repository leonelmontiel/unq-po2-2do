package ar.edu.unq.po2.observer.sistemaArticulos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaRyPBTest {

	private SistemaRyPB sistema; //SUT
	private LectorCientificoListener lectorUno; //DOC
	private LectorCientificoListener lectorDos; //DOC
	private ArticuloCientifico articuloWollok; //DOC

	@BeforeEach
	void setUp() throws Exception {
		this.sistema = new SistemaRyPB();
		this.lectorUno = mock(LectorCientificoListener.class);
		this.lectorDos = mock(LectorCientificoListener.class);
		this.articuloWollok = mock(ArticuloCientifico.class);
		
		this.sistema.suscribirA(this.lectorUno);
		
	}

	@Test
	void testYaContieneALectorUno() {
		//verify
		assertTrue(this.sistema.contieneA(this.lectorUno));
	}
	
	@Test
	void testNoContieneALectorUnoRepetido() {
		//exercise
		this.sistema.suscribirA(this.lectorUno);
		Integer longitudSuscriptores = this.sistema.getSuscriptores().size();
		//verify
		assertEquals(1, longitudSuscriptores);
	}
	
	@Test
	void testDesuscribirALectorUno() {
		//exercise
		this.sistema.desuscribirA(this.lectorUno);
		//verify
		assertFalse(this.sistema.contieneA(this.lectorUno));
	}
	
	@Test
	void testNoDesuscribeALectorDosPorqueNoEst·Suscripto() {
		//exercise
		this.sistema.desuscribirA(this.lectorDos);
		//verify
		assertFalse(this.sistema.contieneA(this.lectorDos));
	}
	
	@Test
	void testCargarArticulo() {
		//exercise
		this.sistema.cargarArticulo(this.articuloWollok);
		//verify
		assertTrue(this.sistema.contienePublicado(this.articuloWollok));
	}
	
	@Test
	void testNoCargaArticuloDuplicado() {
		//exercise
		this.sistema.cargarArticulo(this.articuloWollok);
		this.sistema.cargarArticulo(this.articuloWollok);
		Integer longitudArticulos = this.sistema.getArticulos().size();
		//verify
		assertEquals(1, longitudArticulos);
	}

}
