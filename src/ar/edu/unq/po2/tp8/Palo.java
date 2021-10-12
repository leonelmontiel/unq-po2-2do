package ar.edu.unq.po2.tp8;

public enum Palo implements Equivalente {
	PICA, CORAZON, DIAMANTE, TREBOL;

	@Override
	public Integer getRepresentacion() {
		return this.ordinal();
	}
}
