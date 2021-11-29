package ar.edu.unq.po2.stateStrategy.reproductorMP3;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.stateStrategy.videoJuego.Pantalla;

class ReproductorMP3Test {

	private ReproductorMP3 reproductor;
	private Pantalla pantalla;
	private Song songMock;
	
	@BeforeEach
	void setUp() throws Exception {
		this.pantalla = mock(Pantalla.class);
		this.reproductor = new ReproductorMP3(this.pantalla);
		this.songMock = mock(Song.class);
		
		this.reproductor.setCancionSeleccionada(this.songMock);
	}

	@Test
	void testPlayReproduceLaCancionSeleccionada() {
		//exercise
		this.reproductor.play();
		
		//verify
		verify(this.songMock).play();
	}

	@Test
	void testPauseEnSeleccionDeCancionesProduceUnError() {
		//exercise
		this.reproductor.pause();
		
		//verify
		verify(this.songMock, never()).pause();
		verify(this.pantalla).mostrar("El reproductor no esta reproduciendo");
	}
	
	@Test
	void testStopEnSeleccionDeCancionesNoHaceNada() {
		//exercise
		this.reproductor.stop();
		
		//verify
		verify(this.songMock, never()).stop();
	}
	
	@Test
	void testPlayCuandoEstaReproduciendoLanzaError() {
		//setup
		this.reproductor.play();
		
		//exercise
		this.reproductor.play();
		
		//verify
		verify(this.pantalla).mostrar("El reproductor se encuentra reproduciendo");
		verify(this.songMock, times(1)).play();
	}
	
	@Test
	void testPauseCuandoEstaReproduciendoPausaLaReproduccion() {
		//setup
		this.reproductor.play();
		
		//exercise
		this.reproductor.pause();
		
		//verify
		verify(this.songMock).play();
		verify(this.songMock).pause();
	}
	
	@Test
	void testStopCuandoEstaReproduciendoDetieneLaCancion() {
		//setup
		this.reproductor.play();
		
		//exercise
		this.reproductor.stop();
		
		//verify
		verify(this.songMock).play();
		verify(this.songMock).stop();
	}

	@Test
	void testPlayCuandoEstaPausadoRetomaLaReproduccion() {
		//setup
		this.reproductor.play();
		this.reproductor.pause();
		
		//exercise
		this.reproductor.play();
		
		//verify
		verify(this.songMock).pause();
		verify(this.songMock, times(2)).play();
	}
	
	@Test
	void testPauseCuandoEstaPausadoRetomaLaReproduccion() {
		//setup
		this.reproductor.play();
		this.reproductor.pause();
		
		//exercise
		this.reproductor.pause();
		
		//verify
		verify(this.songMock).pause();
		verify(this.songMock, times(2)).play();
	}
	
	@Test
	void testStopCuandoEstaPausadoDetieneLaPausa() {
		//setup
		this.reproductor.play();
		this.reproductor.pause();
		
		//exercise
		this.reproductor.stop();
		
		//verify
		verify(this.songMock).play();
		verify(this.songMock).pause();
		verify(this.songMock).stop();
	}
}