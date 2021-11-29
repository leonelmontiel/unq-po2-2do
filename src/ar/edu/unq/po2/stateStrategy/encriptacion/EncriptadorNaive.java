package ar.edu.unq.po2.stateStrategy.encriptacion;

public class EncriptadorNaive {
	/*
	 * Delega las peticiones a la instancia de EstrategiaEncriptado que contiene, la cuál puede elegirse manualmente a través del setter
	 */

	private EstrategiaEncriptado estrategia;

	public String enciptar(String stringOrigen) {
		return this.estrategia.encriptar(stringOrigen);		
	}
	
	public String desencriptar(String stringOrigen) {
		return this.estrategia.desencriptar(stringOrigen);
	}

	public void setEstrategia(EstrategiaEncriptado estrategia) {
		this.estrategia = estrategia;
	}

}