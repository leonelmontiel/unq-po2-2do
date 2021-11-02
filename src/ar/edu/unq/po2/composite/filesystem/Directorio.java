package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio extends ElementoFileSystem {
	private List<IFileSystem> contenido = new ArrayList<IFileSystem>();

	public Directorio(String nombre, LocalDate fecha) {
		super(nombre, fecha);
	}

	@Override
	public int totalSize() {
		Integer totalSize = this.getContenido().stream().mapToInt(IFileSystem::totalSize).sum();
		return totalSize;
	}

	public IFileSystem oldestElement() {
		IFileSystem elemMasAntiguo = this.getContenido().stream().reduce(this, (elem, otro)-> ((ElementoFileSystem) elem).elemMasAntiguo(otro));
		return elemMasAntiguo;
	}

	@Override
	public IFileSystem lastModified() {
		IFileSystem elemMasNuevo = this.getContenido().stream().reduce(this, (elem, otro)-> ((ElementoFileSystem) elem).elemMasNuevo(otro));
		return elemMasNuevo;
	}

	@Override
	public void printStructure() {
		// TODO Auto-generated method stub

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
