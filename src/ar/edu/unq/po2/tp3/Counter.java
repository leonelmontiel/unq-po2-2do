package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
	
	private List<Integer> numeros = new ArrayList<Integer>();
	
	void addNumber(int n) {
		numeros.add(n);
	}
	
	long cantTotal() {
		return numeros.size();		
	}
	
	Integer getEvenOcurrences() { //par
		int pares = 0;
		
		for (int num:numeros) {
			if (this.esPar(num)) {
				pares++;
			}
		}
		return pares;
	}
	
	private boolean esPar(int num) {
		return num % 2 == 0;
	}

	Integer getOddOcurrences() { //impar		
		return (int) (cantTotal() - getEvenOcurrences());
	}
	
	long multiplesOf(int num) {
		
		long multiplesOf =+ numeros.stream()
									.filter(n -> esDivisible(n, num))
									.count();
		return multiplesOf;
	}

	private boolean esDivisible(int n, Integer num) {
		return n % num == 0;
	}

	public Integer mayorMultiploDe(int num) {
		List<Integer> numeros = multiplosDe(num);
		
		return Collections.max(numeros);
	}

	private List<Integer> multiplosDe(int num) {
		List<Integer> multiplosDe = numeros.stream()
											.filter(n -> esDivisible(n, num))
											.collect(Collectors.toList());
		
		return multiplosDe;
	}

	public boolean existeMayorMultiploDe(int num) {
		return !this.multiplosDe(num).isEmpty();
	}
}
