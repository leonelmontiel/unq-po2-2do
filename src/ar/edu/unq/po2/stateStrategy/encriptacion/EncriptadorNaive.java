package ar.edu.unq.po2.stateStrategy.encriptacion;

public class EncriptadorNaive {

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