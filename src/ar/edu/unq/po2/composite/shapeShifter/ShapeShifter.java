package ar.edu.unq.po2.composite.shapeShifter;

import java.util.ArrayList;
import java.util.List;

public abstract class ShapeShifter implements IShapeShifter{
	
	protected List<IShapeShifter> elementos = new ArrayList<IShapeShifter>();
	

	@Override
	public IShapeShifter compose(IShapeShifter elemento) {
		IShapeShifter composicion = new Nodo(this, elemento);
		return composicion;
	}

	@Override
	public int deepest() {
		// 0 es la profundidad base de una hoja
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		/* Si el IShapeShifter posee una profundidad m�xima >= 1, entonces retorna un IShapeShifter de profundidad maxima 1 con todos los 
		IShapeShifter de profundidad 0 contenidos. En cualquier otro caso, retorna el mismo IShapeShifter.*/
		return this;
	}

	@Override
	public abstract List<Integer> values();
	
	public Boolean contiene(IShapeShifter elemento) {
		return this.getElementos().contains(elemento);
	}
	
	public List<IShapeShifter> getElementos() {
		return this.elementos;
	}

}
