package ar.edu.unq.po2.observer.juegoPyR;

import java.util.Set;

public interface Cuestionario {

	public Set<String> getPreguntas();

	public Boolean evaluarRespuesta(String pregunta, String respuesta);

}
