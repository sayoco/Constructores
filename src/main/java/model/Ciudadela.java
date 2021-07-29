package model;

import java.sql.Date;
import java.util.ArrayList;

public class Ciudadela {
	private String id;
	private Date fechaInicio;
	private Date fechaEntrega;
    private ArrayList<SolicitudConstruccion> solicitudes;
    private ArrayList<Material> materiales;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
	public ArrayList<SolicitudConstruccion> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(ArrayList<SolicitudConstruccion> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public ArrayList<Material> getMateriales() {
		return materiales;
	}
	public void setMateriales(ArrayList<Material> materiales) {
		this.materiales = materiales;
	}
	public Ciudadela(String id,  Date fechaInicio, Date fechaEntrega, ArrayList<SolicitudConstruccion> solicitudes,
			ArrayList<Material> materiales) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.solicitudes = solicitudes;
		this.materiales = materiales;
	}
	
	
}
