package ar.edu.unq.po2.composite.shapeShifter;

import java.util.List;

public class Hoja extends ShapeShifter {
	
	public List<IShapeShifter> getElementos() {
		System.out.println("Una hoja no puede contener elementos de IShapeShifter");
		return null;
	}

}
