import porcion.*

class PorcionPura inherits Porcion {
	const property cultivo //Cultivo
	
	override method agregarRegion(region) {
		throw "Una porción pura no puede agregar una región"
	}
	
	override method eliminarRegion(region) {
		throw "Una porción pura no tiene regiones para eliminar"
	}
	
	override method gananciaAnual() {
		return cultivo.gananciaAnual()
	}
	
}