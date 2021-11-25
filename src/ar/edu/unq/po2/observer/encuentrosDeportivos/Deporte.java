package ar.edu.unq.po2.observer.encuentrosDeportivos;

public enum Deporte implements AspectoDeInteres {
	FUTBOL, TENIS, BASQUET, PINGPONG;

	@Override
	public Boolean esIgualA(AspectoDeInteres aspecto) {
		return this.equals(aspecto);
	} 

}
