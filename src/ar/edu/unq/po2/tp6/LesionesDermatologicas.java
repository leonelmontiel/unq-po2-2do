package ar.edu.unq.po2.tp6;

public enum LesionesDermatologicas {
	
	ROJO("4"){
		@Override
		public LesionesDermatologicas siguiente() {
			return GRIS;
		}
	}, GRIS("1"){
		@Override
		public LesionesDermatologicas siguiente() {
			return AMARILLO;
		}
	}, AMARILLO("2"){
		@Override
		public LesionesDermatologicas siguiente() {
			return MIEL;
		}
	}, MIEL("3"){
		@Override
		public LesionesDermatologicas siguiente() {
			return ROJO;
		}
	};
	
	public abstract LesionesDermatologicas siguiente();
	
	String nivelRiesgo;
	
	LesionesDermatologicas(String nivel) {
		this.nivelRiesgo = nivel;
	}

	String nivelRiesgo() {
		return this.nivelRiesgo;
	}
	
}

