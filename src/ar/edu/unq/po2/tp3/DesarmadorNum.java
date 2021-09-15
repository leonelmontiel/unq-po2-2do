package ar.edu.unq.po2.tp3;

public class DesarmadorNum {

	public int numConMasPares(int[] arregloNumeros) {
		int numConMasPares = arregloNumeros[0];
		for (int i = 0; i <= arregloNumeros.length; i++) {
			numConMasPares = numeroConMasParesEntre(i, i++);
		}		
		return numConMasPares;
	}

	private int numeroConMasParesEntre(int i, int j) {
		int numConMasPares;
		if (cantParesDe(i) >= cantParesDe(j)) {
			numConMasPares = i;
		} else {
			numConMasPares = j;
		}
		return numConMasPares;
	}

	private int cantParesDe(int i) {
		
		return 0;
	}
	
	

}
