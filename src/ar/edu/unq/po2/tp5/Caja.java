package ar.edu.unq.po2.tp5;

import java.util.List;

public class Caja {
	double montoACobrar;
	MercadoCentral mercado;
	
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
		}
	}
	
	public void cobrarProducto(Producto producto) {
		setMontoACobrar(getMontoACobrar() + producto.getPrecio());
	}

	public void registrarFactura(Factura factura, Agencia agencia) {
		setMontoACobrar(factura.getMontoAPagar());
		notificarPagoAAgencia(factura, agencia);		
	}

	private void notificarPagoAAgencia(Factura factura, Agencia agencia) {
		agencia.registrarPago(factura);
	}

}
