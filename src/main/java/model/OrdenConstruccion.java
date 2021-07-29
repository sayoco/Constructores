package model;

import java.sql.Date;
import util.EstadoOrden;

public class OrdenConstruccion {
	private String id;
	private String estado;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public OrdenConstruccion(String id) {

		this.id = id;
		this.estado = EstadoOrden.Pendiente.toString();
	}
	
}
