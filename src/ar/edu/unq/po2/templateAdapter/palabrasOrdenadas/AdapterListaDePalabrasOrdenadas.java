package ar.edu.unq.po2.templateAdapter.palabrasOrdenadas;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class AdapterListaDePalabrasOrdenadas extends DefaultListModel<String> {
	
	private ListaDePalabrasOrdenadas lista;

	public AdapterListaDePalabrasOrdenadas() {
		this.lista = new ListaDePalabrasOrdenadas();
	}
	
	@Override
	public void addElement(String palabra) {
		this.lista.agregarPalabra(palabra);
	}

	@Override
	public String getElementAt(int index) {
		return lista.getPalabraDePosicion(index);
	}

	@Override
	public int getSize() {
		return lista.cantidadDePalabras();
	}

}
