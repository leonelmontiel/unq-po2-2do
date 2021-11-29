package ar.edu.unq.po2.stateStrategy.encriptacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncriptadorNaiveTest {

	private EncriptadorNaive encriptador;
	private String frase;
	private String fraseEsperada;

	@BeforeEach
	void setUp() throws Exception {
		this.encriptador = new EncriptadorNaive();
		this.frase = "san lorenzo";
	}
	
	@Test
	void testEncriptarIntercanbioVocal() {
		//setup
		this.encriptador.setEstrategia(IntercambioVocal.getInstance());
		this.fraseEsperada = "sen lurinzu";
		
		//verify
		assertEquals(this.fraseEsperada, this.encriptador.enciptar(this.frase));
	}
	
	@Test
	void testDesencriptarIntercanbioVocal() {
		//setup
		this.encriptador.setEstrategia(IntercambioVocal.getInstance());
		this.fraseEsperada = this.frase;
		this.frase = "sen lurinzu";
		
		//verify
		assertEquals(this.fraseEsperada, this.encriptador.desencriptar(this.frase));
	}

	@Test
	void testEncriptarIntercanbioNumerico() {
		//setup
		this.encriptador.setEstrategia(IntercambioNumerico.getInstance());
		this.fraseEsperada = "1911401215185142615";
		
		//verify
		assertEquals(this.fraseEsperada, this.encriptador.enciptar(this.frase));
	}
	
	@Test
	void testDesencriptarIntercanbioNumerico() {
		//setup
		this.encriptador.setEstrategia(IntercambioNumerico.getInstance());
		this.fraseEsperada = this.frase;
		this.frase = "1911401215185142615";

		//exercise (es necesario para que se pueda desencriptar que se haya encriptado previamente)
		this.encriptador.enciptar(this.fraseEsperada);
		
		//verify
		assertEquals(this.fraseEsperada, this.encriptador.desencriptar(this.frase));
	}
	
}
