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
		rectangulo = new Rectangulo(5, 3); //tamaño: base 5, altura 3
	}

	@Test
	void testCreacionRectangulo() {
		// establezco los datos esperados
		 puntoA = new Punto(0, 0); // x e y. El punto A siempre empieza en (0, 0)
		 puntoB = new Punto(5, 0);
		 puntoC = new Punto(5, 3);
		 puntoD = new Punto(0, 3);
		 
		 // guardo los datos arrojados a través del mensaje hacia el objeto
		 getPuntoA = rectangulo.getPuntoA();
		 getPuntoB = rectangulo.getPuntoB();
		 getPuntoC = rectangulo.getPuntoC();
		 getPuntoD = rectangulo.getPuntoD();
		 
		 // corroboro que las coordenadas arrojadas por el objeto sean iguales a las establecidas más arriba
		 assertEquals(getPuntoA.getCoordenadas(), puntoA.getCoordenadas());
		 assertEquals(getPuntoB.getCoordenadas(), puntoB.getCoordenadas());
		 assertEquals(getPuntoC.getCoordenadas(), puntoC.getCoordenadas());
		 assertEquals(getPuntoD.getCoordenadas(), puntoD.getCoordenadas());
	}
	
	@Test
	void testArea() {
		int area = rectangulo.getArea();
		
		assertEquals(area, 15);
	}
	
	@Test
	void testPerimetro() {
		int perimetro = rectangulo.getPerimetro();
		
		assertEquals(perimetro, 16);
	}
	
	@Test
	void testRectanguloNoEsVertical() {
		boolean esVertical = rectangulo.esVertical();
		
		assertFalse(esVertical);
	}
	
	@Test
	void testRectanguloEsHorizontal() {
		boolean esHorizontal = rectangulo.esHorizontal();
		
		assertTrue(esHorizontal);
	}
	
	// para estos dos siguientes test, creo un nuevo rectángulo con otros valores de base y altura
	@Test
	void testRectanguloEsVertical() {
		Rectangulo rect = new Rectangulo(2, 10);
		boolean esVertical = rect.esVertical();
		
		assertTrue(esVertical);
	}
	
	@Test
	void testRectanguloNoEsHorizontal() {
		Rectangulo rect = new Rectangulo(2, 10);
		boolean esHorizontal = rect.esHorizontal();
		
		assertFalse(esHorizontal);
	}

}
