package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter {
	
	private List<Integer> numeros = new ArrayList<Integer>();
	
	void addNumber(int n) {
		numeros.add(n);
	}
	
	long cantTotal() {
		return numeros.size();		
	}
	
	Integer getEvenOcurrences() {
		int impares = 0;
		
		for (int num:numeros) {
			if (num % 2 == 1) {
				impares++;
			}
		}
		return impares;
	}
	
	Integer getOddOcurrences() {		
		return (int) (cantTotal() - getEvenOcurrences());
	}
	
	long multiplesOf(int num) {
		
		long multiplesOf =+ numeros.stream()
									.filter(n -> num % n == 0)
									.count();
		return multiplesOf;
	}
}
