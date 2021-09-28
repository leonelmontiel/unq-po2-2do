package ar.edu.unq.po2.tp5;

public class Producto {
	protected String nombre;
	protected double precio;
	
	public Producto(String nombre, double precio) {
		setNombre(nombre);
		setPrecio(precio);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected double getPrecio() {
		return this.precio;
	}

}
