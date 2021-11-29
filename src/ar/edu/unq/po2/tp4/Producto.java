package ar.edu.unq.po2.tp4;


public class Producto {

	protected String nombre;
	protected double precio;
	protected boolean esPrecioCuidado;
	
	public Producto() {}
	
	public Producto(String nombre, double precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}

	public Producto(String nombre, double precio, boolean pCuidado) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setEsPrecioCuidado(pCuidado);		
	}

	private void setEsPrecioCuidado(boolean pCuidado) {
		this.esPrecioCuidado = pCuidado;		
	}

	protected void setPrecio(double precio) {
		this.precio = precio;		
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	public Object getNombre() {
		return this.nombre;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}

	public void aumentarPrecio(double valor) {
		this.setPrecio(this.getPrecio() + valor);
	}

}
