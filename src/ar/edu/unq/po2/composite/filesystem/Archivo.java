package ar.edu.unq.po2.composite.filesystem;

public class Archivo extends ElementoFileSystem {

	private int totalSize;

	public Archivo(String nombre, int size) {
		super(nombre);
		setSize(size);
	}

	private void setSize(int size) {
		this.totalSize = size;
	}

	@Override
	public int totalSize() {
		return this.totalSize;
	}

}
