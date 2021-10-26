package ar.edu.unq.po2.composite;

public class Caballero extends Peloton {

	@Override
	public void caminarHasta(Integer destino) {
		this.caminarEnZigZagHasta(destino);
	}

	private void caminarEnZigZagHasta(Integer destino) {
		// Para ir de un punto a otro debe caminar en zigzag para controlar que no haya enemigos.
		this.setUbicacion(destino);
		
	}

}
