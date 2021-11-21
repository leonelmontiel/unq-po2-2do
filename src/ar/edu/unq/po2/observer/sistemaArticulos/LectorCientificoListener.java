package ar.edu.unq.po2.observer.sistemaArticulos;

import java.util.Set;

public interface LectorCientificoListener {
	
	void suscribirseA(SistemaRyPB sistema);
	
	void desuscribirseA(SistemaRyPB sistema);

	void recibirNuevoArticulo(SistemaRyPB sistema, ArticuloCientifico articulo);

	Boolean estaInteresadoEnAlgunaPalabraDe(Set<String> palabrasClaves);

}
