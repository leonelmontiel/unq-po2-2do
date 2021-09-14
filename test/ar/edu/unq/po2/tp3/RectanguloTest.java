package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectanguloTest {
	private Rectangulo rectangulo;
	private Punto getPuntoA;
	private Punto getPuntoB;
	private Punto getPuntoC;
	private Punto getPuntoD;
	
	private Punto puntoA;
	private Punto puntoB;
	private Punto puntoC;
	private Punto puntoD;

	@BeforeEach
	void setUp() throws Exception {
		rectangulo = new Rectangulo(5, 3); //tama�o: base 5, altura 3
	}

	@Test
	void testCreacionRectangulo() {
		 puntoA = new Punto(0, 0); // x e y. El punto A siempre empieza en (0, 0)
		 puntoB = new Punto(5, 0);
		 puntoC = new Punto(5, 3);
		 puntoD = new Punto(0, 3);
		 
		 getPuntoA = rectangulo.getPuntoA();
		 getPuntoB = rectangulo.getPuntoB();
		 getPuntoC = rectangulo.getPuntoC();
		 getPuntoD = rectangulo.getPuntoD();
		 
		 assertEquals(getPuntoA.getCoordenadas(), puntoA.getCoordenadas());
		 assertEquals(getPuntoB.getCoordenadas(), puntoB.getCoordenadas());
		 assertEquals(getPuntoC.getCoordenadas(), puntoC.getCoordenadas());
		 assertEquals(getPuntoD.getCoordenadas(), puntoD.getCoordenadas());
	}

}
