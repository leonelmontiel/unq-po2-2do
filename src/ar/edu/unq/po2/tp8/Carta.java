package ar.edu.unq.po2.tp8;

public class Carta {

	private Valor valor;
	private Palo palo;

	public Carta(Valor valor, Palo palo) {
		setValor(valor);
		setPalo(palo);
	}

	private void setValor(Valor valor) {
		this.valor = valor;		
	}

	private void setPalo(Palo palo) {
		this.palo = palo;
		
	}
	
	public Equivalente getValor() {
		return this.valor;
	}
	
	public Equivalente getPalo() {
		return this.palo;
	}

	public boolean esMayorQue(Carta carta) {
		Integer valorPrimera =  this.getValor().getValor();
		Integer valorSegunda = carta.getValor().getValor();
		return valorPrimera > valorSegunda;
	}

	public boolean tieneMismoPaloQue(Carta carta) {
		Equivalente paloPrimera =  this.getPalo();
		Equivalente paloSegunda = carta.getPalo();
		return paloPrimera == paloSegunda;
	}

}
