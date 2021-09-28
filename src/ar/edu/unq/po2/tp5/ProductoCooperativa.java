package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto{

	public ProductoCooperativa(String nombre, double precio) {
		super(nombre, precio);
	}
	
	@Override
	protected double getPrecio() {
		return this.precio - descuentoIVA();
	}

	private double descuentoIVA() {
		return (this.precio * 10) / 100;
	}

}
