package ar.edu.unq.po2.tp8;

public enum Valor {
	DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), J(11), Q(12), K(13), A(14);
	
	Integer valor;

	Valor(Integer valor) {
		setValor(valor);
	}
	
	void setValor(Integer valor) {
		this.valor = valor;		
	}

	Integer getValor() {
		return this.valor;
	}
}
