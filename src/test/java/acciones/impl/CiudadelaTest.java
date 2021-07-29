package acciones.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.Test;

import acciones.interfaces.ICiudadelaAcciones;
import model.SolicitudConstruccion;
import model.Usuario;
import util.DatosUtil;
import util.EstadoOrden;
import util.TiposConstruccion;

class CiudadelaTest {
	@Test 
	void validarFactSolicitudArquitecto() {
		DatosUtil.resetInstance();
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible = ciudadelaDelFuturo.ValidarFactibilidadSolicitud (arquitecto
																				, solicitud);
		assertEquals(true, esFactible);
	}
	@Test 
	void validarFactSolicitudIngeniero() {
		DatosUtil.resetInstance();
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		Usuario ingeniero = DatosUtil.consultarUsuarioPorId("2");
		boolean esFactible = ciudadelaDelFuturo.ValidarFactibilidadSolicitud (ingeniero
																				, solicitud);
		assertEquals(true, esFactible);
	}
	@Test 
	void crearSolicitud() {
		DatosUtil.resetInstance();
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
															 , solicitud);
		assertEquals(true, esFactible);
	}
	
	@Test 
	void crearSolicitudConsultarFecha() {
		DatosUtil.resetInstance();
		System.out.println("Fecha Entrega Ciudadela "+ DatosUtil.getCiudadela().getFechaEntrega() );
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
															 , solicitud);
		System.out.println("Fecha Entrega Ciudadela "+ DatosUtil.getCiudadela().getFechaEntrega() );
		assertEquals(true, esFactible);
	}
	@Test 
	void consultarConstruccionesPendientes() {
		DatosUtil.resetInstance();
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
															 , solicitud);
		SolicitudConstruccion solicitud2 = new SolicitudConstruccion("2"
														, TiposConstruccion.Edificio
														, new BigDecimal(3.0)
														, new BigDecimal(4.0));
		esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
													 , solicitud2);
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.Pendiente.toString());
		System.out.println("Fecha Entrega Ciudadela "+ DatosUtil.getCiudadela().getFechaEntrega() );
		assertEquals(true, esFactible);
	}
	@Test 
	void aperturarCiudadela() {
		DatosUtil.resetInstance();
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		ciudadelaDelFuturo.apertura(Date.valueOf("2021-07-03"));
		
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible;
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		
		esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
															 , solicitud);
		
		SolicitudConstruccion solicitud2 = new SolicitudConstruccion("2"
														, TiposConstruccion.Edificio
														, new BigDecimal(3.0)
														, new BigDecimal(4.0));
		esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
													 , solicitud2);
		
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.Pendiente.toString());
		ciudadelaDelFuturo.apertura(Date.valueOf("2021-07-03"));
		System.out.println("Fecha Entrega Ciudadela "+ DatosUtil.getCiudadela().getFechaEntrega() );
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.En_Progreso.toString());
		
		assertEquals(true, esFactible);
	}
	
	@Test 
	void cerrarCiudadela() {
		DatosUtil.resetInstance();
		ICiudadelaAcciones ciudadelaDelFuturo = new CiudadelaAcciones();
		ciudadelaDelFuturo.apertura(Date.valueOf("2021-07-03"));
		
		Usuario arquitecto = DatosUtil.consultarUsuarioPorId("1");
		boolean esFactible;
		SolicitudConstruccion solicitud = new SolicitudConstruccion("1"
										, TiposConstruccion.Cancha_de_fútbol
										, new BigDecimal(1.0)
										, new BigDecimal(2.0));
		
		esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
															 , solicitud);
		
		SolicitudConstruccion solicitud2 = new SolicitudConstruccion("2"
														, TiposConstruccion.Edificio
														, new BigDecimal(3.0)
														, new BigDecimal(4.0));
		esFactible = ciudadelaDelFuturo.CrearSoicitud(arquitecto
													 , solicitud2);
		
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.Pendiente.toString());
		ciudadelaDelFuturo.apertura(Date.valueOf("2021-07-03"));
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.En_Progreso.toString());
		ciudadelaDelFuturo.cierre(Date.valueOf("2021-07-04"));
		ciudadelaDelFuturo.consultarConstruccionesXEstado(EstadoOrden.Finalizada.toString());
		System.out.println("Fecha Entrega Ciudadela "+ DatosUtil.getCiudadela().getFechaEntrega() );
		
		
		assertEquals(true, esFactible);
	}
	
	

}
