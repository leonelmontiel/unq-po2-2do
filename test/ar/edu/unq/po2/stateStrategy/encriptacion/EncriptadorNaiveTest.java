package ar.edu.unq.po2.stateStrategy.encriptacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncriptadorNaiveTest {

	private EncriptadorNaive encriptador;

	@BeforeEach
	void setUp() throws Exception {
		this.encriptador = new EncriptadorNaive();
	}
	
	@Test
	void testEncriptarIntercanbioVocal() {
		//setup
		this.encriptador.setEstrategia(IntercambioVocal.getInstance());
		String stringOrigen = "Frase a encriptar";
		String stringEsperado = "Fresi e incropter";
		
		//verify
		assertEquals(stringEsperado, this.encriptador.enciptar(stringOrigen));
	}
	
	@Test
	void testDesencriptarIntercanbioVocal() {
		//setup
		this.encriptador.setEstrategia(IntercambioVocal.getInstance());
		String stringOrigen = "Fresi e incropter";
		String stringEsperado = "Frase a encriptar";
		
		//verify
		assertEquals(stringEsperado, this.encriptador.desencriptar(stringOrigen));
	}

	@Test
	void testEncriptarIntercanbioNumerico() {
		//setup
		this.encriptador.setEstrategia(IntercambioNumerico.getInstance());
		String stringOrigen = "frase a encriptar";
		String stringEsperado = "618119501051431891620118";
		
		//verify
		assertEquals(stringEsperado, this.encriptador.enciptar(stringOrigen));
	}
	
	@Test
	void testDesencriptarIntercanbioNumerico() {
		//setup
		this.encriptador.setEstrategia(IntercambioNumerico.getInstance());
		String stringOrigen = "618119501051431891620118";
		String stringEsperado = "frase a encriptar";

		//exercise (es necesario para que se pueda desencriptar que se haya encriptado previamente)
		this.encriptador.enciptar(stringEsperado);
		
		//verify
		assertEquals(stringEsperado, this.encriptador.desencriptar(stringOrigen));
	}
	
}
