package model;

import java.math.BigDecimal;
import java.sql.Date;

import util.TiposConstruccion;

public class SolicitudConstruccion {
	private String id;
	private TipoConstruccion tipoConst;
	private BigDecimal x;
	private BigDecimal y;
	private Date fechaRegistro;
	private Date fechaAtencion;
	private Usuario solicitante;
	private OrdenConstruccion orden;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TipoConstruccion getTipoConst() {
		return tipoConst;
	}
	public void setTipoConst(TipoConstruccion tipoConst) {
		this.tipoConst = tipoConst;
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public BigDecimal getY() {
		return y;
	}
	public void setY(BigDecimal y) {
		this.y = y;
	}
	
	public OrdenConstruccion getOrden() {
		return orden;
	}
	public void setOrden(OrdenConstruccion orden) {
		this.orden = orden;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	
	public SolicitudConstruccion(String id
			, TiposConstruccion tipoConst
			, BigDecimal x
			, BigDecimal y) {
		super();
		this.id = id;
		TipoConstruccion nuevaConstruccion = null;
		switch (tipoConst) {
	    case  Casa:
	    	nuevaConstruccion = new TipoConstruccion(id
	    			                ,tipoConst.toString()
	    			                ,new BigDecimal(100)
	    			    			,new BigDecimal(50)
	    			    			,new BigDecimal(90)
	    			    			,new BigDecimal(20)
	    			    			,new BigDecimal(100)
	    			    			,3);
	    case  Lago:
	    	nuevaConstruccion = new TipoConstruccion(id
	                ,tipoConst.toString()
	                ,new BigDecimal(50)
	    			,new BigDecimal(60)
	    			,new BigDecimal(80)
	    			,new BigDecimal(10)
	    			,new BigDecimal(20)
	    			,2);
	    case  Cancha_de_futbol:
	    	nuevaConstruccion = new TipoConstruccion(id
	                ,tipoConst.toString()
	                ,new BigDecimal(20)
	    			,new BigDecimal(20)
	    			,new BigDecimal(20)
	    			,new BigDecimal(20)
	    			,new BigDecimal(20)
	    			,1);
	    case  Edificio :
	    	nuevaConstruccion = new TipoConstruccion(id
	                ,tipoConst.toString()
	                ,new BigDecimal(200)
	    			,new BigDecimal(100)
	    			,new BigDecimal(180)
	    			,new BigDecimal(40)
	    			,new BigDecimal(200)
	    			,6);
	    case  Gimnasio :
	    	nuevaConstruccion = new TipoConstruccion(id
	                ,tipoConst.toString()
	                ,new BigDecimal(50)
	    			,new BigDecimal(25)
	    			,new BigDecimal(45)
	    			,new BigDecimal(10)
	    			,new BigDecimal(50)
	    			,2);
	    } 
		
		this.tipoConst = nuevaConstruccion;
		this.x = x;
		this.y = y;
	}
   
	
}
