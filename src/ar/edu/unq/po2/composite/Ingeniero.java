package ar.edu.unq.po2.composite;

import java.util.List;

public class Ingeniero extends Peloton{

	private int lajas;

	public Ingeniero(int lajas) {
		setLajas(lajas);
	}

	private void setLajas(int lajas) {
		this.lajas = lajas;
	}

	public int getLajas() {
		return this.lajas;
	}

	@Override
	public void caminarHasta(Integer destino) {
		this.trazarCaminoCortoHacia(destino);		
		this.caminarYDejarLajasHacia(destino);		
		this.setUbicacion(destino);
		
	}

	public void caminarYDejarLajasHacia(Integer destino) {
		for(int paso=0; paso<destino; paso++) {
			this.setUbicacion(paso);
			this.dejarLaja();
		}
	}
	
	private void dejarLaja() {
		setLajas(this.getLajas() - 1);
		System.out.println("Se ha dejado una laja en el camino. Quedan: " + this.getLajas());		
	}

	private Integer trazarCaminoCortoHacia(Integer destino) {
		System.out.println("El Ingeniero ha trazado el camino hacia el destino. Se deben dar " + destino + " pasos.");
		System.out.println("Dispone de  " + this.getLajas() + " lajas en su bolsa.");
		return destino;
	}

	@Override
	public void reclutar(Peloton luchador) {
		System.out.println("No tiene la autoridad para reclutar");
	}
	
	@Override
	public List<Peloton> getLuchadores() {
		System.out.println("No tiene la autoridad para estar a cargo de ning�n pelot�n");
		return null;
	}
	
	@Override
	public void desterrar(Peloton luchador) {
		System.out.println("No tiene la autoridad para desterrar a ning�n soldado");
	}
}
