package ar.edu.unq.po2.composite.filesystem;

import java.time.LocalDate;
import java.util.List;

public class Archivo extends ElementoFileSystem {

	public Archivo(String nombre, int size) {
		super(nombre);
		setSize(size);
	}

	@Override
	public int totalSize() {
		return this.totalSize;
	}

	@Override
	public IFileSystem oldestElement() {
		//elemento m�s antiguo
		return this;
	}

	@Override
	public IFileSystem lastModified() {
		//elemento m�s nuevo
		return this;
	}
	
	@Override
	public void printStructure() {
		System.out.println(this.getNombre());
	}
	
	@Override
	public LocalDate getUltimaModificacion() {
		//retorna la fecha actual ya que no hay ninguna forma de establecer una fecha puntual
		return LocalDate.now();
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
		// no tiene permitido contener ning�n elemento
		return false;
	}

}
