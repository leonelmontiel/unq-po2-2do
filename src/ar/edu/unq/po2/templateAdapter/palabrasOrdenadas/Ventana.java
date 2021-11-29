package ar.edu.unq.po2.templateAdapter.palabrasOrdenadas;

import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	public Ventana(DefaultListModel<String> listModel){
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setBounds(new Rectangle(180,180));
		this.setVisible(true);
		JLabel label=new JLabel("Lista de palabras");
		label.setBounds(new Rectangle(40,40));
		this.add(label);
		listModel.addElement("casa");
		listModel.addElement("arbol");
		listModel.addElement("perro");
		listModel.addElement("telefono");
		listModel.addElement("brazo");
		JList<String> lista = new JList<String>(listModel);
		lista.setBounds(new Rectangle(110,160));
		this.add(lista);
	}
		
	public static void main(String[] args) {
		new Ventana(new AdapterListaDePalabrasOrdenadas());
		/*
		 * antes recibía una instancia de DefaultListModel, pero ahora se le pasa el adaptador de la clase ListaDePalabrasOrdenadas.
		 * La cual esta, a su vez, implementa los métodos que extiende de la clase objetivo DefaultListModel para que interactúe
		 * con la clase adaptable ListaDePalabrasOrdenadas que está como atributo del adaptador
		 * */
	}
}

