package dao.interfaces;

import java.sql.Date;

import model.Ciudadela;
import model.SolicitudConstruccion;
import model.Usuario;


public interface ICiudadela {
	
	public boolean validarFactibilidadSolicitud(Usuario usuario
												, SolicitudConstruccion solicitud);
	
	public boolean crearSolicitud(Usuario usuario
			, SolicitudConstruccion solicitud);
	
	public void ampliarFechaEntrega (Integer numeroDias);
   
	public void apertura(Date fechaHoy);
	
	public void cierre(Date fechaHoy);
	
	public void consultarConstruccionesXEstado(String estado);
	
	public void recargaMateriales(Ciudadela ciudadela);
	
}
