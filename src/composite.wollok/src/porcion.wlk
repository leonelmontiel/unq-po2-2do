class Porcion {
	var property regiones = []
	
	method agregarRegion(region) {
		if (regiones.size() < 4) {
			regiones.add(region)
		} else {
			throw "La región no fue agregada, el límite es de 4"
		}
	}
	
	method eliminarRegion(region) {
		if (regiones.contains(region)) {
			regiones.remove(region)
		} else {
			throw "La región de cultivo no existe"
		}		
	}
	
	method gananciaAnual()
}