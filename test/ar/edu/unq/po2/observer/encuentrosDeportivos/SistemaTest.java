package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {

	private Observador servidor;
	private ServidorObservado sistema;
	@SuppressWarnings("rawtypes")
	private Map asociacionMock;
	private Partido partido;
	private Deporte deporte;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		//config mocks
		this.asociacionMock = mock(Map.class);
		this.servidor = mock(Observador.class);
		this.partido = mock(Partido.class);
		this.deporte = mock(Deporte.class);
		
		this.sistema = new Sistema(this.asociacionMock);
		
	}

	@Test
	void testSuscribirAServidor() {
		//config mocks
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		//exercise
		this.sistema.suscribirA(this.servidor, this.deporte);		
		//verify
		verify(observadoresSpy).add(this.servidor);		
	}
	
	@Test
	void testDesuscribirAServidor() {
		//config mocks
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		//exercise
		this.sistema.desuscribirA(this.servidor, this.deporte);		
		//verify
		verify(observadoresSpy).remove(this.servidor);
	}
	
	@Test
	void testNotificarPartido() {
		//config mocks
		when(this.partido.getDeporte()).thenReturn(this.deporte);
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		//exercise
		this.sistema.suscribirA(this.servidor, this.deporte);	
		this.sistema.notificarPartido(this.partido);
		//verify
		verify(observadoresSpy).add(this.servidor);
		verify(this.servidor).recibirPartido(this.partido);
	}

}
