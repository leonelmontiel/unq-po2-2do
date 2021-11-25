package ar.edu.unq.po2.observer.encuentrosDeportivos;

public class Contrincante implements AspectoDeInteres{

	private String nombre;
	
	public Contrincante(String nombre) {
		this.setNombre(nombre);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

}
