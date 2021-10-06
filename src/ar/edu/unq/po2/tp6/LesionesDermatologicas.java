package ar.edu.unq.po2.tp6;

public enum LesionesDermatologicas {
	
	ROJO("Letal", 4){
		@Override
		public LesionesDermatologicas siguiente() {
			return GRIS;
		}
	}, GRIS("Superficial", 1){
		@Override
		public LesionesDermatologicas siguiente() {
			return AMARILLO;
		}
	}, AMARILLO("Grave", 2){
		@Override
		public LesionesDermatologicas siguiente() {
			return MIEL;
		}
	}, MIEL("Muy grave", 3){
		@Override
		public LesionesDermatologicas siguiente() {
			return ROJO;
		}
	};
	
	public abstract LesionesDermatologicas siguiente();
	
	String descripcion;
	int nivelRiesgo;
	
	LesionesDermatologicas(String desc, int nivel) {
		this.descripcion = desc;
		this.nivelRiesgo = nivel;
	}
	
	String descripcion( ) {
		return this.descripcion;
	}

	int nivelRiesgo() {
		return this.nivelRiesgo;
	}
	
}

