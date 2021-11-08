package ar.edu.unq.po2.composite.shapeShifter;

public class Nodo extends ShapeShifter {
	
	public Nodo(ShapeShifter shapeShifter, IShapeShifter otroShapeShifter) {
		this.elementos.add(shapeShifter);
		this.elementos.add(otroShapeShifter);
	}
	
}
