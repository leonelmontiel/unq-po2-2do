package ar.edu.unq.po2.tp7;

import java.util.List;

public interface IServidorCorreo {
	// acá encontramos violaciones al principio de Segregaciónd de Interfaces
	
	public List<Correo> recibirNuevos(String user, String pass);

	public void conectar(String nombreUsuario, String passusuario);

	public void enviar(Correo correo);
	
	/*Todas estas firmas deberían ser parte de otra interface que se encargue de el estado de un servidor.
	public float tazaDeTransferencia();

	public void resetear();
	
	public void realizarBackUp();*/

}
