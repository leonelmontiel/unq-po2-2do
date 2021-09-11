package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class Punto {
	private Integer coordX;
	private Integer coordY;
	
	public Punto() { //coordenada origen
		setCoordX(0);
		setCoordY(0);
	}

	public Punto(int i, int j) { //coordenada establecidas por el usuario
		setCoordX(i);
		setCoordY(j);
	}

	private void setCoordX(int i) {
		coordX = i;		
	}

	private void setCoordY(int i) {
		coordY = i;		
	}

	public List<Integer> getCoordenadas() {
		List<Integer> coord = new ArrayList<Integer>();
		coord.add(coordX);
		coord.add(coordY);
		return coord;
	}

	public void moverCoordA(int i, int j) {
		setCoordX(i);
		setCoordY(j);	
	}

	public void sumarseCon(int i, int j) {
		setCoordX(getCoordX() + i);
		setCoordY(getCoordY() + j);			
	}

	private int getCoordX() {
		return this.coordX;
	}
	
	private int getCoordY() {
		return this.coordY;
	}

}
