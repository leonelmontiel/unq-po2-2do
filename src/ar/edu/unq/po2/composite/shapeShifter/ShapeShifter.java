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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean contiene(ShapeShifter elemento) {
		return this.getElementos().contains(elemento);
	}
	
	public List<IShapeShifter> getElementos() {
		return this.elementos;
	}

}
