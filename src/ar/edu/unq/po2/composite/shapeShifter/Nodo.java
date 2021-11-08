package ar.edu.unq.po2.composite.shapeShifter;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends ShapeShifter {
	
	private int profundidad;
	
	public Nodo() {}

	public Nodo(ShapeShifter shapeShifter, IShapeShifter otroShapeShifter) {
		this.elementos.add(shapeShifter);
		this.elementos.add(otroShapeShifter);
		this.profundidad = mayorProfundidadEntre(shapeShifter, otroShapeShifter) + 1;
	}
	
	public Nodo(List<IShapeShifter> elementosAchatados) {
		this.elementos = elementosAchatados;
	}

	public int mayorProfundidadEntre(ShapeShifter shapeShifter, IShapeShifter otroShapeShifter) {
		return Math.max(shapeShifter.deepest(), otroShapeShifter.deepest());
	}

	@Override
	public int deepest() {
		return this.profundidad;
	}
	
	@Override
	public IShapeShifter flat() {
		List<IShapeShifter> elementosAchatados = new ArrayList<IShapeShifter>();
		this.getElementos().stream().forEach(elem -> elementosAchatados.addAll(((ShapeShifter) elem).getElementos()));
		return new Nodo(elementosAchatados);
	}
	
}
