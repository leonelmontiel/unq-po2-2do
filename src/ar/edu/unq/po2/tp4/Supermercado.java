package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private String nombre;
	private String direccion;
	private List<Producto> productos = new ArrayList<Producto>();

	public Supermercado(String nombre, String direccion) {
		setNombre(nombre);
		setDireccion(direccion);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;		
	}

	public Integer getCantidadDeProductos() {
		return productos.size();
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public Double getPrecioTotal() {
		double precioTotal = productos.stream().mapToDouble(p -> p.getPrecio())
												.sum();
		return precioTotal;
	}

}
