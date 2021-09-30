package ar.edu.unq.po2.tp6;

public enum Deporte {
	RUNNING(1), FUTBOL(2), BASKET(2), TENNIS(3), JABALINA(4);
	
	private Integer complejidad;
	
	Deporte(Integer num) {
		this.complejidad = num;
	}
	
	public Integer getComplejidad() {
		return this.complejidad;
	}
}
