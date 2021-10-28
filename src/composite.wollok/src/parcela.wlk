
class Parcela {
	const property porciones = []
	
	method agregarPorcion(porcion) {
		if (porciones.size() < 4) {
			porciones.add(porcion)
		}
	}
	
	method gananciaAnual() {
		const sumatoria = porciones.sum({region => region.gananciaAnual()})
		return sumatoria
	}

}

