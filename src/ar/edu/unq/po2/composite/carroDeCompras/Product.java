package ar.edu.unq.po2.composite.carroDeCompras;

public class Product {
	
	protected float price;
	protected String name;

	public Product(String nombre, float precio) {
		setName(nombre);
		setPrice(precio);
	}

	private void setName(String nombre) {
		this.name = nombre;		
	}

	private void setPrice(float precio) {
		this.price = precio;		
	}

	public float getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

}
