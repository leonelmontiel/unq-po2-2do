package ar.edu.unq.po2.composite.shapeShifter;

import java.util.Arrays;
import java.util.List;

public class Hoja extends ShapeShifter {
	
	private int value;

	public Hoja(int value) {
		this.value = value;
	}

	@Override
	public List<IShapeShifter> getElementos() {
		//se devuelve a sí misma en una lista porque esto es útil para el método flat() en nodo
		return Arrays.asList(this);
	}
	
	@Override
	public Boolean contiene(IShapeShifter elemento) {
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

	@Override
	public IShapeShifter flat() {
		/* Si el IShapeShifter posee una profundidad máxima >= 1, entonces retorna un IShapeShifter de profundidad maxima 1 con todos los 
		IShapeShifter de profundidad 0 contenidos. En cualquier otro caso, retorna el mismo IShapeShifter.*/
		return this;
	}

	@Override
	public int deepest() {
		// 0 es la profundidad base de una hoja
		return 0;
	}

}
