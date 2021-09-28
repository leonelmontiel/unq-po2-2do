package ar.edu.unq.po2.tp5;

import java.util.List;

import ar.edu.unq.po2.tp4.Producto;

public class MercadoCentral {
	List<Producto> stock;
	
	public void addProducto(Producto producto) {
		stock.add(producto);
	}

	public boolean hayStockDe(Producto producto) {
		return stock.contains(producto);
	}

	public void decrementarStockDe(Producto producto) {
		stock.remove(producto);		
	}	

}
