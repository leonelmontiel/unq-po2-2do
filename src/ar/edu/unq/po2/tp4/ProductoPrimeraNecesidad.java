package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto{

	public ProductoPrimeraNecesidad(String nombre, double precio, boolean pCuidado, double descuento) {
		super();
		setPrecio(precio, descuento);
	}
	
	private void setPrecio(double precio, double descuento) {
		double formula = 1 - (descuento / 100);
		this.precio = precio * (formula);
	}

}
