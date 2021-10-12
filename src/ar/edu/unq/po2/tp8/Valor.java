package ar.edu.unq.po2.tp8;

public enum Valor {
	DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, J, Q, K, A;

	boolean esMayorQue(Valor valor) {
		return this.ordinal() > valor.ordinal();
	}
}
