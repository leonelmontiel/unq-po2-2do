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
	
	public Valor getValor() {
		return this.valor;
	}
	
	public Palo getPalo() {
		return this.palo;
	}

	public boolean esMayorQue(Carta carta) {
		Integer valorPrimera =  this.getValor(this);
		Integer valorSegunda = getValor(carta);
		return valorPrimera > valorSegunda;
	}

	public Integer getValor(Carta carta) {
		return carta.getValor().getRepresentacion();
	}

	public boolean tieneMismoPaloQue(Carta carta) {
		Palo paloPrimera =  this.getPalo();
		Palo paloSegunda = carta.getPalo();
		return paloPrimera == paloSegunda;
	}

}
