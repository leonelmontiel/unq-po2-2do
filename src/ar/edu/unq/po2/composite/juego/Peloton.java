package ar.edu.unq.po2.composite.juego;

import java.util.ArrayList;
import java.util.List;

public abstract class Peloton {
	// COMPUESTO

	protected int ubicacion; // representa la cantidad de pasos hasta un determinado destino
	protected List<Peloton> soldados = new ArrayList<Peloton>();

	public abstract void caminarHasta(Integer destino);

	public Integer getUbicacion() {
		return this.ubicacion;
	}
	
	protected void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void reclutar(Peloton luchador) {
		this.soldados.add(luchador);
	}
	
	public void desterrar(Peloton soldado) {
		this.soldados.remove(soldado);
	}

	public List<Peloton> getSoldados() {
		return this.soldados ;
	}
	
	public Boolean contains(Peloton soldado) {
		return this.getSoldados().contains(soldado);
	}

}
