package ar.edu.unq.po2.observer.encuentrosDeportivos;

public enum Deporte implements AspectoDeInteres {
	FUTBOL("futbol"), TENIS("tenis"), BASQUET("basquet"), PINGPONG("ping-pong");

	private String nombre;
	
	private Deporte(String nombre) {
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
