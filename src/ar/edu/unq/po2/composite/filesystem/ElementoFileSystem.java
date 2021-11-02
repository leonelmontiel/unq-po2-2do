package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.List;

public abstract class ElementoFileSystem implements IFileSystem{
	protected String nombre;
	protected int totalSize;
	protected LocalDate fechaCreacion;
	protected LocalDate lastModified;
	
	public ElementoFileSystem(String nombre, LocalDate fecha) {
		setNombre(nombre);
		setFechaCreacion(fecha);
		setLastModified(LocalDate.now());
	}

	private void setFechaCreacion(LocalDate fecha) {
		this.fechaCreacion = fecha;
	}
	
	private void setLastModified(LocalDate fecha) {
		this.lastModified = fecha;		
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;		
	}
	
	protected void setSize(int size) {
		this.totalSize = size;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	@Override
	public abstract int totalSize();
	
	@Override
	public abstract IFileSystem oldestElement(); // elemento más antiguo

	@Override
	public abstract IFileSystem lastModified(); // elemento más nuevo
	
	public abstract List<IFileSystem> getContenido();
	
	public abstract void agregarElemento(IFileSystem elemento);
	
	public abstract boolean contains(IFileSystem elemento);

	public IFileSystem elemMasAntiguo(IFileSystem elemento) {
		return this.esMasAntiguoQue(elemento) ? this : elemento;
	}

	private boolean esMasAntiguoQue(IFileSystem elemento) {
		return this.getFechaCreacion().isBefore(((ElementoFileSystem) elemento).getFechaCreacion());
	}

	public IFileSystem elemMasNuevo(IFileSystem elemento) {
		// básicamente niego el resultado de la comparación entre los dos elementos para saber si el primero es más antiguo que el segundo
		return !this.esMasAntiguoQue(elemento) ? this : elemento;
	}
	
	@Override
	public void printStructure() {
		System.out.println(this.estructuraPrint(""));
	}

	protected abstract String estructuraPrint(String string);

}
