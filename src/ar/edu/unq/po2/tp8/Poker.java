package ar.edu.unq.po2.tp8;

import java.util.List;
import java.util.stream.Collectors;

public class Poker extends Jugada {

	public Poker(List<Carta> cartas) {
		super(cartas);
		this.valor = 3;
	}
	
	@Override
	public Carta cartaDeterminante() {
		Valor valorCarta = this.getCartas().stream().collect(Collectors.groupingBy(c -> c.getValor())).entrySet().stream()
				.filter(e -> e.getValue().size() > 1).map(e->e.getKey()).collect(Collectors.toList()).get(0);
		List<Carta> cartas = this.getCartas().stream().filter(c-> c.getValor().equals(valorCarta)).collect(Collectors.toList());
		for (Carta carta:cartas) {
			System.out.println(carta.getValor());
			System.out.println(carta.getPalo());
		}
		return cartas.get(0);
	}
}