package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.List;

public abstract class ElementoFileSystem implements IFileSystem{
	protected String nombre;
	protected int totalSize;
	
	public ElementoFileSystem(String nombre) {
		setNombre(nombre);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;		
	}
	
	protected void setSize(int size) {
		this.totalSize = size;
	}
	
	@Override
	public abstract int totalSize();
	
	@Override
	public abstract IFileSystem oldestElement(); // elemento más antiguo

	@Override
	public abstract IFileSystem lastModified(); // elemento más nuevo
	
	@Override
	public abstract void printStructure();
	
	public abstract List<IFileSystem> getContenido();
	
	public abstract void agregarElemento(IFileSystem elemento);

	public abstract LocalDate getUltimaModificacion();	
	
	public abstract boolean contains(IFileSystem elemento);

}
