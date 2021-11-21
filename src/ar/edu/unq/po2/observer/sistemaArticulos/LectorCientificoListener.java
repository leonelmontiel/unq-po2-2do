package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.Set;

public interface LectorCientificoListener {

	void recibirNuevoArticulo(SistemaRyPB sistema, ArticuloCientifico articuloWollok);

	void recibirArticuloSiEstaInteresado(Set<String> palabrasClaves);

	Boolean estaInteresadoEnAlgunaPalabraDe(Set<String> palabrasClaves);

	Set<String> getIntereses();

}
