package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto{

	public ProductoPrimeraNecesidad(String nombre, double precio, boolean pCuidado) {
		super();
		setPrecio(precio);
	}
	
	@Override
	protected void setPrecio(double precio) {
		this.precio = precio * 0.9;
	}

}
