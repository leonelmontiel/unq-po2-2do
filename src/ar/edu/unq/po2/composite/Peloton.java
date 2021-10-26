package ar.edu.unq.po2.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Peloton {

	protected int ubicacion; // representa la cantidad de pasos hasta un determinado destino
	protected List<Peloton> luchadores = new ArrayList<Peloton>();

	public abstract void caminarHasta(Integer destino);

	public Integer getUbicacion() {
		return this.ubicacion;
	}
	
	protected void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void reclutar(Peloton luchador) {
		this.luchadores.add(luchador);
	}
	
	public void desterrar(Peloton luchador) {
		this.luchadores.remove(luchador);
	}

	public List<Peloton> getLuchadores() {
		return this.luchadores ;
	}

}
