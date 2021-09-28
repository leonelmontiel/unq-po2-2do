package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	double montoACobrar;
	MercadoCentral mercado;
	List<Producto> productosCobrados = new ArrayList<Producto>();
	
	public Caja(MercadoCentral mercado) {
		setMercado(mercado);
	}
	
	private void setMercado(MercadoCentral mercado) {
		this.mercado = mercado;
	}
	
	public double registrarProductos(List<Producto> productos) {
		resetearCaja();
		
		productos.stream().forEach((p) -> {
			cobrarSiHayStockDe(p);
			});
		
		return getMontoACobrar();
	}

	public double getMontoACobrar() {
		return this.montoACobrar;
	}

	private void resetearCaja() {
		setMontoACobrar(0);		
	}
	
	private void setMontoACobrar(double valor) {
		this.montoACobrar = valor;
	}
	
	public void cobrarSiHayStockDe(Producto producto) {
		if (mercado.hayStockDe(producto)) {
			mercado.decrementarStockDe(producto);
			cobrarProducto(producto);
			guardarProductoEnHistorial(producto);
		}
	}
	
	public void cobrarProducto(Producto producto) {
		setMontoACobrar(getMontoACobrar() + producto.getPrecio());
	}
	
	private void guardarProductoEnHistorial(Producto producto) {
		productosCobrados.add(producto);
	}

}
