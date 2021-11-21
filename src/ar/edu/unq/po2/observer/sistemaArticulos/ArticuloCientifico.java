package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.Set;

public class ArticuloCientifico {
	
	private String titulo;
	private Autor autor;
	private String tipo;
	private String lugar;
	private Set<String> palabrasClaves;
	
	public ArticuloCientifico(String titulo, Autor autor, String tipo, String lugar, Set<String> palabrasClaves) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setTipo(tipo);
		this.setLugar(lugar);
		this.setPalabrasClaves(palabrasClaves);
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;		
	}

	private void setAutor(Autor autor) {
		this.autor = autor;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private void setLugar(String lugar) {
		this.lugar = lugar;		
	}

	private void setPalabrasClaves(Set<String> palabrasClaves) {
		this.palabrasClaves = palabrasClaves;		
	}

	public String getTitulo() {
		return this.titulo;
	}
	
	public Autor getAutor() {
		return this.autor;
	}
	
	public Set<String> getFiliacionesAutor() {
		return this.autor.getFiliaciones();
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getLugar() {
		return this.lugar;
	}

	public Set<String> getPalabrasClaves() {
		return this.palabrasClaves;
	}

}
