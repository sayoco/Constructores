package acciones.impl;

import java.sql.Date;

import acciones.interfaces.ICiudadelaAcciones;
import dao.impl.CiudadelaDao;
import dao.interfaces.ICiudadela;
import model.SolicitudConstruccion;
import model.Usuario;

public class CiudadelaAcciones implements ICiudadelaAcciones {
	
	private ICiudadela ciudadelaDelFuturo = new CiudadelaDao();

	public boolean ValidarFactibilidadSolicitud (Usuario usuario
												, SolicitudConstruccion solicitud) {
		return ciudadelaDelFuturo.validarFactibilidadSolicitud(usuario, solicitud);
	}
	
	public boolean CrearSoicitud (Usuario usuario
			, SolicitudConstruccion solicitud) {
		
		return ciudadelaDelFuturo.crearSolicitud(usuario, solicitud);
	}	
	
    public void consultarConstruccionesXEstado(String estado) {
		ciudadelaDelFuturo.consultarConstruccionesXEstado(estado);
	}
    
    public void apertura(Date fechaHoy) {
    	ciudadelaDelFuturo.apertura(fechaHoy);
    }
    
    public void cierre(Date fechaHoy) {
    	ciudadelaDelFuturo.cierre(fechaHoy);
    }
	

}
