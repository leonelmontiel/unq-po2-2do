package ar.edu.unq.po2.composite.shapeShifter;

import java.util.Arrays;
import java.util.List;

public class Hoja extends ShapeShifter {
	
	private int value;

	public Hoja(int value) {
		this.value = value;
	}

	public List<IShapeShifter> getElementos() {
		//se devuelve a sí misma en una lista porque esto es útil para el método flat() en nodo
		return Arrays.asList(this);
	}
	
	@Override
	public Boolean contiene(ShapeShifter elemento) {
		System.out.println("Una hoja no puede contener elementos de IShapeShifter");
		return false;
	}

	public int getValue() {
		return this.value;
	}
	
	@Override
	public List<Integer> values() {
		return Arrays.asList(this.getValue());
	}

}
