package ar.edu.unq.po2.observer.encuentrosDeportivos;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServidorDeporteTest {

	private App app;
	private App appDos;
	private App appTres;
	private ServidorDeporte servidor;
	private Deporte deporte;
	@SuppressWarnings("rawtypes")
	private Map asociacionMock;
	private Contrincante contrincante;
	private Contrincante contrincanteDos;
	private Partido partido;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		//config mock
		this.asociacionMock = mock(Map.class);
		this.app = mock(App.class);
		this.appDos = mock(App.class);
		this.appTres = mock(App.class);
		this.deporte = mock(Deporte.class);
		this.contrincante = mock(Contrincante.class);
		this.contrincanteDos = mock(Contrincante.class);
		this.partido = mock(Partido.class);
		
		
		this.servidor = new ServidorDeporte(this.asociacionMock);
		
	}

	@Test
	void testSuscribirAppConInteresEnDeporte() {
		//config mock
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		//exercise
		this.servidor.suscribirA(this.app, this.deporte);
		//verify
		verify(observadoresSpy).add(this.app);		
	}
	
	@Test
	void testSuscribirAppConInteresEnContrincante() {
		//config mock
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.contrincante)).thenReturn(observadoresSpy);
		//exercise
		this.servidor.suscribirA(this.app, this.contrincante);
		//verify
		verify(observadoresSpy).add(this.app);		
	}

	@Test
	void testDesuscribirAppConInteresEnDeporte() {
		//config mocks
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		//exercise
		this.servidor.desuscribirA(this.app, this.deporte);		
		//verify
		verify(observadoresSpy).remove(this.app);
	}
	
	@Test
	void testDesuscribirAppConInteresEnContrincante() {
		//config mocks
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.contrincante)).thenReturn(observadoresSpy);
		//exercise
		this.servidor.desuscribirA(this.app, this.contrincante);		
		//verify
		verify(observadoresSpy).remove(this.app);
	}
	
	@Test
	void testNotificarPartidoSegunDeporte() {
		//config mock
		when(this.partido.getDeporte()).thenReturn(this.deporte);
		when(this.partido.getContrincantes()).thenReturn(Arrays.asList(this.contrincante, this.contrincanteDos));
		Set<Observador> observadoresSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.deporte)).thenReturn(observadoresSpy);
		Set<Observador> observadorContrincanteSpy = spy(new HashSet<Observador>());
		Set<Observador> observadorContrincanteDosSpy = spy(new HashSet<Observador>());
		when(this.asociacionMock.get(this.contrincante)).thenReturn(observadorContrincanteSpy);
		when(this.asociacionMock.get(this.contrincanteDos)).thenReturn(observadorContrincanteDosSpy);
		//exercise
		this.servidor.suscribirA(this.app, this.deporte);
		this.servidor.suscribirA(this.appDos, this.contrincante);
		this.servidor.suscribirA(this.appTres, this.contrincanteDos);
		this.servidor.suscribirA(this.appTres, this.deporte);
		this.servidor.recibirPartido(this.partido);
		//verify
		verify(this.app).recibirPartido(this.partido);
		verify(this.appDos).recibirPartido(this.partido);
		verify(this.appTres).recibirPartido(this.partido);
	}
}
