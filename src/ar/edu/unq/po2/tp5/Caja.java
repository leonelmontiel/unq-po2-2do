package ar.edu.unq.po2.tp5;

import java.util.List;

public class Caja implements Agencia{
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

	@Override
	public void registrarPago(Factura factura) {
		setMontoACobrar(factura.getMontoAPagar());
		notificarPagoAAgencia(factura);		
	}

	private void notificarPagoAAgencia(Factura factura) {
		// No s� como implementar este m�todo para que lo pueda testear luego en los test, ya que Agencia es una interface
		// y no un objeto al que le podamos enviar mensajes. Se me ocurre as�:
		System.out.println("Se ha notificado a la Agencia Recaudadora el cobro de: " + factura.getDescripcion());
		System.out.println("El monto cobrado es: $" + factura.getMontoAPagar());
	}

}
