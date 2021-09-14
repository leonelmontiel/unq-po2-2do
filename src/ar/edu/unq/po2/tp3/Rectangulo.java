package ar.edu.unq.po2.tp3;


public class Rectangulo {
	private int base;
	private int altura;
	private Punto puntoA;
	private Punto puntoB;
	private Punto puntoC;
	private Punto puntoD;	

	public Rectangulo(int b, int a) { // tamaño: base x altura
		setBase(b);
		setAltura(a);
		setPuntoA(); // la creación del rectángulo comienza en el punto origen (0, 0)
		setPuntoB(b, a);
		setPuntoC(b, a);
		setPuntoD(b, a);
	}

	private void setBase(int b) {
		this.base = b;		
	}

	private void setAltura(int a) {
		this.altura = a;		
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

	public int getArea() {
		return getBase() * getAltura();
	}
	
	private int getBase() {
		return this.base;
	}

	private int getAltura() {
		return this.altura;
	}

	public int getPerimetro() {
		return (2 * getBase()) + (2 * getAltura());
	}

	// estos métodos de posicionamiento son inútiles para una clase cuadrado, ya que no se puede lo puede considerar vertical u horizontal
	public boolean esVertical() {
		return getAltura() > getBase();
	}

	public boolean esHorizontal() {
		return getBase() > getAltura();
	}

	

}
