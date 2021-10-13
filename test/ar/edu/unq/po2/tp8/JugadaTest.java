package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadaTest {
	
	private Jugada poker;
	private Jugada color;
	private Jugada colorAlto;
	private Jugada trio;
	private Jugada pokerDeSietes;
	private Jugada pokerDeCincos;

	private Carta carta1 = mock(Carta.class);
	private Carta carta2 = mock(Carta.class);
	private Carta carta3 = mock(Carta.class);
	private Carta carta4 = mock(Carta.class);
	private Carta carta5 = mock(Carta.class);
	private List<Carta> jugada1;
	
	private Carta carta6 = mock(Carta.class);
	private Carta carta7 = mock(Carta.class);
	private Carta carta8 = mock(Carta.class);
	private Carta carta9 = mock(Carta.class);
	private Carta carta10 = mock(Carta.class);
	private List<Carta> jugada2;

	@BeforeEach
	void setUp() throws Exception {
		
		//PrimeraJugada
		when(this.carta1.getValor()).thenReturn(Valor.SIETE);
		when(this.carta1.getPalo()).thenReturn(Palo.PICA);
		when(this.carta1.esMayorQue(carta6)).thenReturn(true);

		when(this.carta2.getValor()).thenReturn(Valor.SIETE);
		when(this.carta2.getPalo()).thenReturn(Palo.DIAMANTE);

		when(this.carta3.getValor()).thenReturn(Valor.SIETE);
		when(this.carta3.getPalo()).thenReturn(Palo.CORAZON);

		when(this.carta4.getValor()).thenReturn(Valor.SIETE);
		when(this.carta4.getPalo()).thenReturn(Palo.TREBOL);

		when(this.carta5.getValor()).thenReturn(Valor.Q);
		when(this.carta5.getPalo()).thenReturn(Palo.PICA);
		

		//Segunda Jugada
		when(this.carta6.getValor()).thenReturn(Valor.CINCO);
		when(this.carta6.getPalo()).thenReturn(Palo.PICA);

		when(this.carta7.getValor()).thenReturn(Valor.CINCO);
		when(this.carta7.getPalo()).thenReturn(Palo.DIAMANTE);

		when(this.carta8.getValor()).thenReturn(Valor.CINCO);
		when(this.carta8.getPalo()).thenReturn(Palo.CORAZON);

		when(this.carta9.getValor()).thenReturn(Valor.CINCO);
		when(this.carta9.getPalo()).thenReturn(Palo.TREBOL);

		when(this.carta10.getValor()).thenReturn(Valor.K);
		when(this.carta10.getPalo()).thenReturn(Palo.DIAMANTE);
		when(this.carta10.esMayorQue(carta5)).thenReturn(true);
		
		this.jugada1 = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		this.jugada2 = Arrays.asList(carta6, carta7, carta8, carta9, carta10);
		
		this.poker = new Poker(jugada1);
		this.color = new Color(jugada1);
		this.colorAlto = new Color(jugada2);
		this.trio = new Trio(jugada1);
		this.pokerDeSietes = new Poker(jugada1);
		this.pokerDeCincos = new Poker(jugada2);
	}

	@Test
	void testPokerGanaColor() {
		assertTrue(this.poker.leGanaA(this.color));
	}
	
	@Test
	void testColorNoGanaPoker() {
		assertFalse(this.color.leGanaA(this.poker));
	}
	
	@Test
	void testColorLeGanaATrio() {
		assertTrue(this.color.leGanaA(this.trio));		
	}

	@Test
	void testTrioNoLeGanaAColor() {
		assertFalse(this.trio.leGanaA(this.color));		
	}
	
	@Test
	void testPokerLeGanaATrio() {
		assertTrue(this.poker.leGanaA(this.trio));		
	}

	@Test
	void testTrioNoLeGanaAPoker() {
		assertFalse(this.trio.leGanaA(this.poker));		
	}

	@Test
	void testColorLeGanaAColor() {
		assertTrue(this.colorAlto.leGanaA(this.color));
	}
	
	@Test
	void testColorNoLeGanaAColor() {
		assertFalse(this.color.leGanaA(this.colorAlto));
	}
	
	@Test
	void testPokerDeSietesGanaPokerDeCincos() {
		assertTrue(this.pokerDeSietes.leGanaA(this.pokerDeCincos));
	}
}