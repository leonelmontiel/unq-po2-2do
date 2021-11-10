package ar.edu.unq.po2.composite.shapeShifter;

import java.util.Arrays;
import java.util.List;

public class Hoja extends ShapeShifter {
	
	private int value;

	public Hoja(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
	@Override
	public List<Integer> values() {
		return Arrays.asList(this.getValue());
	}

}
