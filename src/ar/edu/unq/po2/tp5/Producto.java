package ar.edu.unq.po2.tp5;

public class Producto {
	protected String marca;
	protected double precio;
	
	public Producto(String marca, double precio) {
		setMarca(marca);
		setPrecio(precio);
	}

	private void setMarca(String marca) {
		this.marca = marca;		
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected double getPrecio() {
		return this.precio;
	}

}
