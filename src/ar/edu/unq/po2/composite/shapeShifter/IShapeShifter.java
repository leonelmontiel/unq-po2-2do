package ar.edu.unq.po2.composite.shapeShifter;

import java.util.List;

public interface IShapeShifter {
	public IShapeShifter compose(IShapeShifter elemento);
	public int deepest();
	public IShapeShifter flat();
	public List<Integer> values();
}

