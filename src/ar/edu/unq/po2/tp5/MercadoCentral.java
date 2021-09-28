package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class MercadoCentral {
	List<Producto> stock = new ArrayList<Producto>();
	
	public void addProducto(Producto producto) {
		stock.add(producto);
	}

	public boolean hayStockDe(Producto producto) {
		return stock.contains(producto);
	}

	public void decrementarStockDe(Producto producto) {
		stock.remove(producto);		
	}

	public List<Producto> getStock() {
		return this.stock;
	}	

}
