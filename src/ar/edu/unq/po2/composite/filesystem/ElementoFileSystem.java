package ar.edu.unq.po2.composite.filesystem;

public abstract class ElementoFileSystem implements IFyleSystem{
	protected String nombre;
	
	public ElementoFileSystem(String nombre) {
		setNombre(nombre);
	}

	@Override
	public abstract int totalSize();
	
	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;		
	}

}
