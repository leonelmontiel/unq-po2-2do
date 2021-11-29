package ar.edu.unq.po2.tp5;

import java.util.List;

public class Caja {
	double montoACobrar;
	MercadoCentral mercado;
	
	public Caja(MercadoCentral mercado) {
		this.setMercado(mercado);
	}
	
	private void setMercado(MercadoCentral mercado) {
		this.mercado = mercado;
	}
	
	public double registrarProductos(List<Producto> productos) {
		this.resetearCaja();
		
		productos.stream().forEach((p) -> {
			this.cobrarSiHayStockDe(p);
			});
		
		return this.getMontoACobrar();
	}

	public double getMontoACobrar() {
		return this.montoACobrar;
	}

	private void resetearCaja() {
		this.setMontoACobrar(0);		
	}
	
	private void setMontoACobrar(double valor) {
		this.montoACobrar = valor;
	}
	
	public void cobrarSiHayStockDe(Producto producto) {
		if (this.mercado.hayStockDe(producto)) {
			this.mercado.decrementarStockDe(producto);
			this.cobrarProducto(producto);
		}
	}
	
	public void cobrarProducto(Producto producto) {
		this.setMontoACobrar(getMontoACobrar() + producto.getPrecio());
	}

	public void registrarFactura(Factura factura, Agencia agencia) {
		this.setMontoACobrar(factura.getMontoAPagar());
		this.notificarPagoAAgencia(factura, agencia);		
	}

	private void notificarPagoAAgencia(Factura factura, Agencia agencia) {
		agencia.registrarPago(factura);
	}

}
