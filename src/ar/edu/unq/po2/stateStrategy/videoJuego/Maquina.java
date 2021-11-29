package ar.edu.unq.po2.stateStrategy.videoJuego;

public class Maquina {

	private Integer cantidadJugadores;
	private Integer fichasIngresadas;
	private EstadoMaquina estado;
	private Pantalla pantalla;
	
	public Maquina(Pantalla pantalla) {
		this.cantidadJugadores = 0;
		this.fichasIngresadas = 0;
		this.estado = Inicial.getInstance(); 
		this.pantalla = pantalla;
	}
	
	void setCantidadJugadores(Integer cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	
	public Integer getCantidadJugadores() {
		return this.cantidadJugadores;
	}
	
	void setEstado(EstadoMaquina estado) {
		this.estado = estado;
	}	
	
	public Integer getFichasIngresadas() {
		return this.fichasIngresadas;
	}

	public void presionarBotonInicio() {
		this.estado.presionarBotonInicio(this);
	}

	public void ingresarFicha() {
		this.estado.ingresarFicha(this);
	}
	
	void incrementarFichas() {
		this.fichasIngresadas += 1;
	}
	
	void decrementarFichas(Integer cantidad) {
		this.fichasIngresadas -= cantidad;
	}

	Boolean juegoIniciado() {
		return this.estado.juegoIniciado(this);
	}

	void finalizarJuego() {
		this.estado.finalizarJuego(this);
	}

	void notificarAlJugador(String mensaje) {
		this.pantalla.mostrar(mensaje);
	}

}
