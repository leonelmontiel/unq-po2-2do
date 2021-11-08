package ar.edu.unq.po2.composite.shapeShifter;

import java.util.List;

public interface IShapeShifter {
	/*	Este método recibe un IShapeShifter y retorna un nuevo IShapeShifter que es el 
		resultado de componer al receptor con el que es enviado como parámetro. La 
		composición se realiza al mismo nivel de profundidad.*/
	public IShapeShifter compose(IShapeShifter elemento);
	
	/*	Retorna un numero que representa la profundidad máxima alcanzada en 
		composiciones que contiene.*/
	public int deepest();
	
	/*	Achata un IShapeShifter. Si el IShapeShifter posee una prfundidad maxima >= 1, 
		entonces retorna un IShapeShifter de profundidad maxima 1 con todos los 
		IShapeShifter de profundidad 0 contenidos. En cualquier otro caso, retorna el 
		mismo IShapeShifter.*/
	public IShapeShifter flat();
	
	//	Retorna una lista de enteros con los valores incluidos en el IShapeShifter. 
	public List<Integer> values();
}

