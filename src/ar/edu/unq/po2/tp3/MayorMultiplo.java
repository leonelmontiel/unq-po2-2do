package ar.edu.unq.po2.tp3;

public class MayorMultiplo {

	public Integer mayorMultiploEntre(int x, int y) {
		int menor = elMenorEntre(x, y);
		int mayor = elMayorEntre(x, y);
		int i = elMayorEntre(x, y);
		
		Counter counter = new Counter();
		
		while (menor * i <= 1000) {
			counter.addNumber(menor * i);
			i++;
		}
		
		return MultiploMayorOMenosUno(mayor, counter);
	}

	private Integer MultiploMayorOMenosUno(int num, Counter counter) {
		if (counter.existeMayorMultiploDe(num)) {
			return counter.mayorMultiploDe(num);
		} else {
			return -1;
		}
	}

	private int elMenorEntre(int x, int y) {
		int valorMenor;
		if (x <= y) {
			valorMenor = x;
		} else {
			valorMenor = y;
		}
		return valorMenor;
	}

	private int elMayorEntre(int x, int y) {
		int valorMayor;
		if (x >= y) {
			valorMayor = x;
		} else {
			valorMayor = y;
		}
		return valorMayor;
	}
	
}
