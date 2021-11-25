package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {

	private AspectoDeInteres aspecto;
	private Observador servidor;
	private ServidorObservado sistema;
	@SuppressWarnings("rawtypes")
	private Map asociacionMock;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		//config mocks
		this.asociacionMock = mock(Map.class);
		this.aspecto = mock(AspectoDeInteres.class);
		this.servidor = mock(Observador.class);
		
		this.sistema = new Sistema(this.asociacionMock);
		
	}

	@Test
	void testSuscribirAServidor() {
		//config mocks
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.aspecto)).thenReturn(observadoresSpy);
		//exercise
		this.sistema.suscribirA(this.servidor, this.aspecto);		
		//verify
		verify(observadoresSpy).add(this.servidor);
		
	}

}
