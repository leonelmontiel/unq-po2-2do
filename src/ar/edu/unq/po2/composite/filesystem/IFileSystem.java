package ar.edu.unq.po2.composite.filesystem;

public interface IFileSystem {

	public int totalSize();

	public String getNombre();

	public IFileSystem oldestElement();

	public IFileSystem lastModified();

}
