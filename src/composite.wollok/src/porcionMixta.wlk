import porcion.*

class PorcionMixta inherits Porcion {
	
	override method gananciaAnual() {
		const sumatoria = regiones.sum({region => region.gananciaAnual()})
		return sumatoria / regiones.size()
	}
	
}