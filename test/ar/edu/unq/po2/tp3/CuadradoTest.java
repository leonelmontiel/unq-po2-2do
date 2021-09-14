package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuadradoTest {
	private Cuadrado cuadrado;
	
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
		cuadrado = new Cuadrado(5, 5);
	}

	@Test
	void testCreacionCuadrado() {
		// establezco los datos esperados
		 puntoA = new Punto(0, 0); // x e y. El punto A siempre empieza en (0, 0)
		 puntoB = new Punto(5, 0);
		 puntoC = new Punto(5, 5);
		 puntoD = new Punto(0, 5);
		 
		 // guardo los datos arrojados a través del mensaje hacia el objeto
		 getPuntoA = cuadrado.getPuntoA();
		 getPuntoB = cuadrado.getPuntoB();
		 getPuntoC = cuadrado.getPuntoC();
		 getPuntoD = cuadrado.getPuntoD();
		 
		 // corroboro que las coordenadas arrojadas por el objeto sean iguales a las establecidas más arriba
		 assertEquals(getPuntoA.getCoordenadas(), puntoA.getCoordenadas());
		 assertEquals(getPuntoB.getCoordenadas(), puntoB.getCoordenadas());
		 assertEquals(getPuntoC.getCoordenadas(), puntoC.getCoordenadas());
		 assertEquals(getPuntoD.getCoordenadas(), puntoD.getCoordenadas());
	}
	
	@Test
	void testArea() {
		int area = cuadrado.getArea();
		
		assertEquals(area, 25);
	}
	
	@Test
	void testPerimetro() {
		int perimetro = cuadrado.getPerimetro();
		
		assertEquals(perimetro, 20);
	}

}
