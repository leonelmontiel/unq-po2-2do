package ar.edu.unq.po2.tp3;


public class DesarmadorNum {

	public int numConMasPares(int[] arregloNumeros) {
		int numConMasPares = arregloNumeros[0];
		for (int num:arregloNumeros) {
			numConMasPares = numeroConMasParesEntre(numConMasPares, num);
		}		
		return numConMasPares;
	}

	int numeroConMasParesEntre(int i, int j) {
		int numConMasPares;
		if (cantParesDe(i) >= cantParesDe(j)) {
			numConMasPares = i;
		} else {
			numConMasPares = j;
		}
		return numConMasPares;
	}
	
	public int cantCifras(int i) {
		int num = i;
		int cifras = 1;
		
		while (num >= 10) {
			num = num / 10;
			cifras++;
		}
		return cifras;
	}
	
	public int cantParesDe(int num) {
		int indice = cantCifras(num);
		Counter counter = new Counter();
		
		for(int i = 0; i < indice; i++) {
			counter.addNumber(num % 10);
			num = num / 10;
		}
		return counter.getEvenOcurrences();
	}
	
	

}
