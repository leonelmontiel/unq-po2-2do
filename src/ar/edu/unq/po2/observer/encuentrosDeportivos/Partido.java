package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.List;

public class Partido {

	private String resultado;
	private List<String> contrincantes; //podría ser un Set para que no contengan contrincantes repetidos
	private Deporte deporte;

	public Partido(String resultado, List<String> contrincantes, Deporte deporte) {
		this.setContrincantes(contrincantes);
		this.setResultado(resultado);
		this.setDeporte(deporte);
	}

	private void setDeporte(Deporte deporte) {
		this.deporte = deporte;		
	}

	private void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;		
	}

	private void setResultado(String resultado) {
		this.resultado = resultado;		
	}

	public String getResultado() {
		return this.resultado;
	}

	public List<String> getContrincantes() {
		return this.contrincantes;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}
	
}
