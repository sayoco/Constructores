package dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.interfaces.ICiudadela;
import model.Ciudadela;
import model.Material;
import model.OrdenConstruccion;
import model.SolicitudConstruccion;
import model.Usuario;
import util.DatosUtil;
import util.EstadoOrden;

public class CiudadelaDao implements ICiudadela {
	
	private DatosUtil datosUtil = DatosUtil.getInstance();

	public boolean validarFactibilidadSolicitud(Usuario usuario
			, SolicitudConstruccion solicitud) {
		//validar perfil del usuario
		if (!usuario.getPerfil().getId().equals("arquitecto")) {
			System.out.println("Solicitud NO factible: Usuario solicitante no autorizado");
			return false;
		}
		//validar cantidad de materiales
		for (Material m : datosUtil.getCiudadela().getMateriales() ) {
			if (m.getCantidad().compareTo(BigDecimal.ZERO) != 1) {
				return false;
			}
			switch (m.getId()) {
			    case  Cemento:
			    	  if (m.getCantidad().compareTo(solicitud.getTipoConst().getCe()) < 0) {
			    		  System.out.println("Solicitud NO factible: Cantidad de Cemento insuficiente");
			    		  return false;
			    	  }
			    case  Grava:
			    	  if (m.getCantidad().compareTo(solicitud.getTipoConst().getGr()) < 0) {
			    		  System.out.println("Solicitud NO factible: Cantidad de Grava insuficiente");
			    		  return false;
			    	  }
			    case  Arena:
			    	  if (m.getCantidad().compareTo(solicitud.getTipoConst().getAr()) < 0) {
			    		  System.out.println("Solicitud NO factible: Cantidad de Arena insuficiente");
			    		  return false;
			    	  }
			    case  Madera:
			    	  if (m.getCantidad().compareTo(solicitud.getTipoConst().getMa()) < 0) {
			    		  System.out.println("Solicitud NO factible: Cantidad de Madera insuficiente");
			    		  return false;
			    	  }
			    case  Adobe:
			    	  if (m.getCantidad().compareTo(solicitud.getTipoConst().getAd()) < 0) {
			    		  System.out.println("Solicitud NO factible: Cantidad de Adobe insuficiente");
			    		  return false;
			    	  }
			} 
		}
		//validar coordenadas
		for (SolicitudConstruccion s : datosUtil.getCiudadela().getSolicitudes() ) {
			if (s.getX().compareTo(solicitud.getX()) == 0 && s.getY().compareTo(solicitud.getY()) == 0){
				System.out.println("Coordenadas no disponibles");
				return false;
			}
		}
		System.out.println("Solicitud factible");
		return true;
    }

	public boolean crearSolicitud(Usuario usuario
			, SolicitudConstruccion solicitud) {
		
		if (validarFactibilidadSolicitud(usuario, solicitud)) {
			//Crear orden en estado pendiente
			OrdenConstruccion orden = new OrdenConstruccion(solicitud.getId());
			//Programar Orden
			programarOrden(orden, solicitud.getTipoConst().getDuracion());
			//Relacionar orden a la solicitud
			solicitud.setOrden(orden);
			//Actualizar fecha de entrega de la ciudadela
			ampliarFechaEntrega(solicitud.getTipoConst().getDuracion());
			//Agregar solicitud
			datosUtil.getCiudadela().getSolicitudes().add(solicitud);
			System.out.println("Solicitud de construcción creada");
			;
		}else {
			return false;
		}		
		return true;
		
	}
			
	public void ampliarFechaEntrega (Integer numeroDias) {
		    String fecha;
			final Calendar calendario = Calendar.getInstance();
			calendario.setTime(datosUtil.getCiudadela().getFechaEntrega());
			calendario.add(Calendar.DAY_OF_YEAR,  numeroDias);
			
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			fecha = sdf.format(calendario.getTime());
			datosUtil.getCiudadela().setFechaEntrega(Date.valueOf(fecha));	
	}
	
	public void programarOrden(OrdenConstruccion orden,Integer numeroDias) {
		String fechaInicio;
		String fechaFinalizacion;
		final Calendar calendario = Calendar.getInstance();
		calendario.setTime(datosUtil.getCiudadela().getFechaEntrega());
		calendario.add(Calendar.DAY_OF_YEAR, 1);
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		fechaInicio = sdf.format(calendario.getTime());
		orden.setFechaInicio(Date.valueOf(fechaInicio));
		
		calendario.add(Calendar.DAY_OF_YEAR, numeroDias-1);
		fechaFinalizacion = sdf.format(calendario.getTime());
		orden.setFechaFinalizacion(Date.valueOf(fechaFinalizacion));
		
	}
	
	public void consultarConstruccionesXEstado(String estado) {
		System.out.println("--------------------------------------------------------");
		System.out.println("	Reporte de Construcciones en Estado "+estado);
		System.out.println("	Código	-	Tipo Construcción	-	Coordenadas (x,y)	-	Fecha Inicio	-	Fecha Finalización ");
		for (SolicitudConstruccion s : datosUtil.getCiudadela().getSolicitudes()) {
			if(s.getOrden().getEstado().equals(estado)) {
				System.out.println("	"+s.getId()+"	-	"
				+s.getTipoConst().getTipo()+"	-		("
				+s.getX()+","+s.getY()+")		-	"
				+s.getOrden().getFechaInicio()+"	-	"
				+s.getOrden().getFechaFinalizacion());
			}
			
		}
		
		
	}
	
	public void recargaMateriales(Ciudadela ciudadela) {};
	
	public void apertura(Date fechaHoy) {
		System.out.println("Inicia proceso de apertura de ciudadela "+fechaHoy);
		//iniciar construcciones
		        int i = 0;
				for (SolicitudConstruccion s : datosUtil.getCiudadela().getSolicitudes()) {
					if(s.getOrden().getFechaInicio().equals(fechaHoy)) {
						s.getOrden().setEstado(EstadoOrden.En_Progreso.toString());
						i++;
				    }
				}
		System.out.println("Finaliza proceso de apertura de ciudadela. "+i+" construcciones iniciadas.");
	}
	
	public void cierre(Date fechaHoy) {
		System.out.println("Inicia proceso de cierre de ciudadela "+fechaHoy);
		//Finalizar construcciones
		 int i = 0;
		for (SolicitudConstruccion s : datosUtil.getCiudadela().getSolicitudes()) {
			if(s.getOrden().getFechaFinalizacion().equals(fechaHoy)) {
				s.getOrden().setEstado(EstadoOrden.Finalizada.toString());
				i++;
		    }
		}
		System.out.println("Finaliza proceso de cierre de ciudadela. "+i+" construcciones finalizadas.");
	}
	
}
