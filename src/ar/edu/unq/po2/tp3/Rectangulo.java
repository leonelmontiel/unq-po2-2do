package ar.edu.unq.po2.tp3;


public class Rectangulo {
	private Punto puntoA;
	private Punto puntoB;
	private Punto puntoC;
	private Punto puntoD;

	public Rectangulo(int b, int a) { // tamaño: base x altura
		this.setPuntoA(); // la creación del rectángulo comienza en el punto origen (0, 0)
		this.setPuntoB(b, a);
		this.setPuntoC(b, a);
		this.setPuntoD(b, a);
	}

	public Punto getPuntoA() {
		return puntoA;
	}
	
	private void setPuntoA() {
		this.puntoA = new Punto();		
	}
	
	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(int b, int a) {
		int coordX = b;
		int coordY = 0;
		this.puntoB = new Punto(coordX, coordY);
	}

	public Punto getPuntoC() {
		return puntoC;
	}

	public void setPuntoC(int b, int a) {
		int coordX = b;
		int coordY = a;
		this.puntoC = new Punto(coordX, coordY);
	}

	public Punto getPuntoD() {
		return puntoD;
	}

	public void setPuntoD(int b, int a) {
		int coordX = 0;
		int coordY = a;
		this.puntoD = new Punto(coordX, coordY);
	}

}
