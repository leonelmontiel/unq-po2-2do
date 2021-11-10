package ar.edu.unq.po2.composite.shapeShifter;
import java.util.List;

public abstract class ShapeShifter implements IShapeShifter{	

	@Override
	public IShapeShifter compose(IShapeShifter elemento) {
		IShapeShifter composicion = new Nodo(this, elemento);
		return composicion;
	}
	
	public abstract Boolean contiene(IShapeShifter elemento);
	
	public abstract List<IShapeShifter> getElementos();

}
