package ar.edu.unq.po2.stateStrategy.encriptacion;

public abstract class EstrategiaEncriptado {

	public String encriptar(String texto){
		char[] toProcess = texto.toCharArray();
		String resultado = "";
		for (char letra:toProcess) {
			resultado = resultado + this.codificar(letra);
		}
		return resultado;
	}

	public abstract String desencriptar(String texto);
	
	protected abstract String codificar(char letra);
	
}
