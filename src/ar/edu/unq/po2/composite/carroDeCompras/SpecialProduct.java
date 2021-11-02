package ar.edu.unq.po2.composite.carroDeCompras;

public class SpecialProduct extends Product{
	
	public SpecialProduct(String nombre, float precio) {
		super(nombre, precio);
	}

	@Override
	public float getPrice() {
		//devuelve un precio distinto al de un producto ordinario
		return this.price;
	}

}
