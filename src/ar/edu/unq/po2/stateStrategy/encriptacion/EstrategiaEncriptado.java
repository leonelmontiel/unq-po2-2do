package ar.edu.unq.po2.stateStrategy.encriptacion;

public abstract class EstrategiaEncriptado {

	public String encriptar(String texto){
		/*
		 * Este método funciona como un template. La estructura es la misma para todas las subclases, pero estas están obligadas
		 * a implementar a su manera el método condificar
		 */
		char[] arregloDeLetras = texto.toCharArray();
		String resultado = "";
		for (char letra : arregloDeLetras) {
			resultado = resultado + this.codificar(letra);
		}
		return resultado;
	}

	// Operación primitiva
	public abstract String desencriptar(String texto);
	
	// Hook Method
	protected abstract String codificar(char letra);
	
}
