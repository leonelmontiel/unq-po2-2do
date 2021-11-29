package ar.edu.unq.po2.tp4;

public class Ingreso {

	private String mes;
	private String concepto;
	private Double monto;

	public Ingreso(String mes, String concepto, double monto) {
		this.setMes(mes);
		this.setConcepto(concepto);
		this.setMonto(monto);
	}

	private void setMes(String mes) {
		this.mes = mes;	
	}

	private void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	private void setMonto(double monto) {
		this.monto = monto;		
	}

	public Double getMonto() {		
		return this.monto;
	}

	public Double getMontoImponible() {
		return getMonto();
	}

}
