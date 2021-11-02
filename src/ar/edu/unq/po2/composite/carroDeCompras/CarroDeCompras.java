package ar.edu.unq.po2.composite.carroDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarroDeCompras {

	private List<Product> elements = new ArrayList<Product>();;

	public List<Product> getElements() {
		return this.elements;
	}

	public void agregar(Product producto) {
		this.elements.add(producto);	
	}

}
