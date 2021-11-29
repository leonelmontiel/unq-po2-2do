package ar.edu.unq.po2.stateStrategy.encriptacion;

import java.util.HashMap;
import java.util.Map;

public class IntercambioNumerico extends EstrategiaEncriptado {
	
	private static IntercambioNumerico instance;
	private Map<String, String> memoria;
	private String codigo;
	
	public static EstrategiaEncriptado getInstance() {
		if (instance == null) {
			instance = new IntercambioNumerico();
		}
		return instance;
	}
	
	private IntercambioNumerico() {
		this.memoria = new HashMap<String, String>();
		this.codigo = " abcdefghijklmnopqrstuvwxyz";
	}

	@Override
	public String encriptar(String texto) {
		String resultado = super.encriptar(texto);
		this.memoria.put(resultado, texto);
		return resultado;
	}

	@Override
	public String desencriptar(String texto) {
		String resultado = this.memoria.get(texto);
		this.memoria.remove(texto);
		return resultado;
	}
	
	@Override
	protected String codificar(char letra) {
		return String.valueOf(this.codigo.indexOf(letra));	
	}

}
