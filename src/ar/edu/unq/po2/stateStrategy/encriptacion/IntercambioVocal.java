package ar.edu.unq.po2.stateStrategy.encriptacion;

public class IntercambioVocal extends EstrategiaEncriptado {

	private static EstrategiaEncriptado instance;
	private String claves;
	private String valores;
	
	/*
	 *  siempre que se quiera crear una instancia de IntercambioVocal, debe llamarse al método estático getInstance() para evaluar retornar una
	 *  nueva instancia de la clase o si ya hay una, devolver esta (respeta el patrón Singleton para que exista una única instancia en el sistema).
	 *  Esto es para seguir la misma lógica que posee IntercambioNumerico
	 */
	
	public static EstrategiaEncriptado getInstance() {
		if (instance == null) {
			instance = new IntercambioVocal();
		}
		return instance;
	}
	
	private IntercambioVocal() {
		this.claves = "aeiou";
		this.valores = "eioua";
	}
	
	@Override
	public String desencriptar(String texto) {
		char[] toProcess = texto.toCharArray();
		String resultado = "";
		for (char letra:toProcess) {
			resultado = resultado + this.decodificar(letra);
		}
		return resultado;
	}
	
	@Override
	protected String codificar(char letra) {
		String sLetra = String.valueOf(letra);
		String codificado = (this.claves.contains(sLetra)) ? this.getValor(letra) : sLetra;
		return codificado;	
	}

	private String decodificar(char letra) {
		String sLetra = String.valueOf(letra);
		String decodificado = (this.claves.contains(sLetra)) ? this.getClave(letra) : sLetra;
		return decodificado;
	}
	
	private String getValor(char letra) {
		int i = this.claves.indexOf(letra); 
		return String.valueOf(this.valores.charAt(i));
	}

	private String getClave(char letra) {
		int i = this.valores.indexOf(letra); 
		return String.valueOf(this.claves.charAt(i));
	}

}