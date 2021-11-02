package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.List;

public class Archivo extends ElementoFileSystem {

	public Archivo(String nombre,int size, LocalDate fecha) {
		super(nombre, fecha);
		setSize(size);
	}

	@Override
	public int totalSize() {
		return this.totalSize;
	}

	@Override
	public IFileSystem oldestElement() {
		//elemento más antiguo
		return this;
	}

	@Override
	public IFileSystem lastModified() {
		//elemento más nuevo
		return this;
	}
	
	@Override
	public void printStructure() {
		System.out.println(this.getNombre());
	}

	@Override
	public List<IFileSystem> getContenido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarElemento(IFileSystem elemento) {
		// no puede agregar
	}

	@Override
	public boolean contains(IFileSystem elemento) {
		// no tiene permitido contener ningún elemento
		return false;
	}

	@Override
	protected String estructuraPrint(String separador) {
		return separador + "-" + this.getNombre();
	}

}
