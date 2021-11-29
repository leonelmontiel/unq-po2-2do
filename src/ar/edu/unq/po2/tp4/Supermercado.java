package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private String nombre;
	private String direccion;
	private List<Producto> productos = new ArrayList<Producto>();

	public Supermercado(String nombre, String direccion) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;		
	}

	public Integer getCantidadDeProductos() {
		return this.productos.size();
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public Double getPrecioTotal() {
		double precioTotal = this.productos.stream().mapToDouble(p -> p.getPrecio())
												.sum();
		return precioTotal;
	}

}
