package ar.edu.unq.po2.tp7;

import java.util.ArrayList;

public class ClienteEMail {
	// los atributos deberían estar privados para no ser modificados directamente
	 ServidorPop servidor; //debería ser una instancia de IServidor, se viola el principio open-closed en caso de que se implemente otro tipo de
	 // servidor
	 String nombreUsuario;
	 String passusuario;
	 ArrayList<Correo> inbox; // debería ser un List porque esto está sujeto solo a una instancia de ArrayList, y no por ejemplo de LinkedList
	 // viola el principio Open-Closed
	private ArrayList<Correo> borrados;
	
	public ClienteEMail(ServidorPop servidor, String nombreUsuario, String pass){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.conectar();
	}
	
	// debería ser private, porque la idea es que se ejecute solo una vez, cuando se instancia la clase
	public void conectar(){
		//se deberían usar getters
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo); // debería estar solo este procedimiento
		this.borrados.remove(correo); // esto debería llamar al mensaje eliminarBorrado(Correo), es código repetido
	}
	
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
		//se deberían usar getters
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo){
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}

}
