package acciones.interfaces;

import java.sql.Date;

import model.SolicitudConstruccion;
import model.Usuario;

public interface ICiudadelaAcciones {
	public boolean ValidarFactibilidadSolicitud (Usuario usuario
			                                     ,SolicitudConstruccion solicitud);	
	
	public boolean CrearSoicitud (Usuario usuario
            ,SolicitudConstruccion solicitud);	
	
	public void consultarConstruccionesXEstado(String estado) ;
	
	public void apertura(Date fechaHoy);
	
	public void cierre(Date fechaHoy);
}
