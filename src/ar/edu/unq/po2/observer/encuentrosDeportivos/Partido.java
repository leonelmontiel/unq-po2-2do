package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.List;

public class Partido {

	private String resultado;
	private List<Contrincante> contrincante; //podría ser un Set para que no contengan contrincantes repetidos
	private Deporte deporte;

	public Partido(String resultado, List<Contrincante> contrincante, Deporte deporte) {
		this.setContrincantes(contrincante);
		this.setResultado(resultado);
		this.setDeporte(deporte);
	}

	private void setDeporte(Deporte deporte) {
		this.deporte = deporte;		
	}

	private void setContrincantes(List<Contrincante> contrincante) {
		this.contrincante = contrincante;		
	}

	private void setResultado(String resultado) {
		this.resultado = resultado;		
	}

	public String getResultado() {
		return this.resultado;
	}

	public List<Contrincante> getContrincantes() {
		return this.contrincante;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}
	
}
