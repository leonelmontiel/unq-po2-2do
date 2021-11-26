package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Set;

public class Juego implements IJuego{
	/*
	 * Se contempla una única partida en curso
	 * */

	private Set<IJugador> jugadores;

	@Override
	public void solicitaIngreso(IJugador jugador) {
		if (!this.iniciado()) {
			this.getJugadores().add(jugador);
		}
	}

	public Set<IJugador> getJugadores() {
		return this.jugadores;
	}

	private Boolean iniciado() {
		return this.cantidadDeJugadores() == 5;
	}

	private int cantidadDeJugadores() {
		return this.getJugadores().size();
	}

	@Override
	public void notificarListoParaJugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarJuegoIniciado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarJuegoFinalizado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) {
		// TODO Auto-generated method stub
		
	}

	void setJugadores(Set<IJugador> jugadores) {
		this.jugadores = jugadores;		
	}

}
