package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio extends ElementoFileSystem {

	private LocalDate fechaCreacion;
	private List<IFileSystem> contenido = new ArrayList<IFileSystem>();

	public Directorio(String nombre) {
		super(nombre);
		setFechaCreacion(LocalDate.now());
	}

	private void setFechaCreacion(LocalDate now) {
		this.fechaCreacion = now;	
	}

	@Override
	public int totalSize() {
		
		return 0;
	}

	@Override
	public IFileSystem oldestElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFileSystem lastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printStructure() {
		// TODO Auto-generated method stub

	}
	
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}

	@Override
	public List<IFileSystem> getContenido() {
		return this.contenido;
	}

	@Override
	public LocalDate getUltimaModificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarElemento(IFileSystem elemento) {
		this.contenido.add(elemento);		
	}
	
	@Override
	public boolean contains(IFileSystem elemento) {
		return this.getContenido().contains(elemento);
	}

}
