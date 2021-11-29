package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class MercadoCentral {
	List<Producto> stock = new ArrayList<Producto>();
	
	public void addProducto(Producto producto) {
		this.stock.add(producto);
	}

	public boolean hayStockDe(Producto producto) {
		return this.stock.contains(producto);
	}

	public void decrementarStockDe(Producto producto) {
		this.stock.remove(producto);		
	}

	public List<Producto> getStock() {
		return this.stock;
	}	

}
