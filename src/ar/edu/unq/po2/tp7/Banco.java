package ar.edu.unq.po2.tp7;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<SolicitudCredito> solicitudes  = new ArrayList<SolicitudCredito>();

	public Boolean tieneClientes() {
		return !clientes.isEmpty();
	}

	public Boolean tieneSolicitudes() {
		return !solicitudes.isEmpty();
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
		
	}

	public void registrarSolicitud(SolicitudCredito solicitud) {
		solicitudes.add(solicitud);
		
	}

}
