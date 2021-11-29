package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto{

	public ProductoCooperativa(String marca, double precio) {
		super(marca, precio);
	}
	
	@Override
	protected double getPrecio() {
		return this.precio - this.descuentoIVA();
	}

	private double descuentoIVA() {
		return (this.precio * 10) / 100;
	}

}
