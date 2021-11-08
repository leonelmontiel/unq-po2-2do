package ar.edu.unq.po2.composite.shapeShifter;

public class Nodo extends ShapeShifter {
	
	private int profundidad;

	public Nodo(ShapeShifter shapeShifter, IShapeShifter otroShapeShifter) {
		this.elementos.add(shapeShifter);
		this.elementos.add(otroShapeShifter);
		this.profundidad = mayorProfundidadEntre(shapeShifter, otroShapeShifter) + 1;
	}
	
	public int mayorProfundidadEntre(ShapeShifter shapeShifter, IShapeShifter otroShapeShifter) {
		return Math.max(shapeShifter.deepest(), otroShapeShifter.deepest());
	}

	@Override
	public int deepest() {
		return this.profundidad;
	}
	
}
