package ar.edu.unq.po2.tp7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<SolicitudCredito> solicitudes = new ArrayList<SolicitudCredito>();
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<SolicitudCredito> getSolicitudes() {
		return this.solicitudes;
	}

	public Boolean tieneClientes() {
		return !this.getClientes().isEmpty();
	}

	public void agregarCliente(Cliente cliente) {
		this.getClientes().add(cliente);
	}

	public Boolean tieneSolicitudes() {
		return !this.getSolicitudes().isEmpty();
	}

	public void registrarSolicitud(SolicitudCredito solicitud) {
		this.getSolicitudes().add(solicitud);
	}

	public Float getTotalADesembolsar() {
		return this.getSolicitudesAprobadas().stream().map(SolicitudCredito::getMonto)
				.reduce(0f, (acumulado, monto)-> {return acumulado + monto;});
	}

	private List<SolicitudCredito> getSolicitudesAprobadas() {
		return this.getSolicitudes().stream().filter(solicitud-> solicitud.esAceptable())
				.collect(Collectors.toList());
	}

}
