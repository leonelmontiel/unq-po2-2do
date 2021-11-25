package ar.edu.unq.po2.observer.encuentrosDeportivos;

public class Contrincante implements AspectoDeInteres{

	@Override
	public Boolean esIgualA(AspectoDeInteres aspecto) {
		return this.equals(aspecto);
	}

}
