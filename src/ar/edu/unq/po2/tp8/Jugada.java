package ar.edu.unq.po2.tp8;

import java.util.Comparator;
import java.util.List;

public abstract class Jugada {

	protected Integer valor;
	private List<Carta> cartas;
	
	public Jugada(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Integer getValor() {
		return this.valor;
	}
	
	public List<Carta> getCartas(){
		return this.cartas;
	}

	public Boolean leGanaA(Jugada unaJugada) {
		if(this.empata(unaJugada)) {
			return this.ganaPorEmpate(unaJugada);
		}else {
		return this.getValor() > unaJugada.getValor();}
	}
	
	private boolean empata(Jugada unaJugada) {
		return this.getValor().equals(unaJugada.getValor());
	}

	private Boolean ganaPorEmpate(Jugada unaJugada) {
		return this.cartaDeterminante().esMayorQue(unaJugada.cartaDeterminante());
	}

	protected Carta cartaDeterminante() {
		return this.getCartas().stream().max(Comparator.comparing(Carta::getValor)).get();
	}

}
