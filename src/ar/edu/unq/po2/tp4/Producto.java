package ar.edu.unq.po2.tp4;


public class Producto {

	protected String nombre;
	protected double precio;
	protected boolean esPrecioCuidado;
	
	public Producto() {}

	public Producto(String nombre, double precio, boolean pCuidado) {
		setNombre(nombre);
		setPrecio(precio);
		setEsPrecioCuidado(pCuidado);		
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

	public Producto(String nombre, double precio) {
		setNombre(nombre);
		setPrecio(precio);
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
		setPrecio(getPrecio() + valor);
	}

}
