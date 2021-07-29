package model;

import java.math.BigDecimal;

import util.TiposMaterial;

public class Material {
	private TiposMaterial id;
	private BigDecimal Cantidad;
	
	public void setId(TiposMaterial id) {
		this.id = id;
	}
	public TiposMaterial getId() {
		return id;
	}
	
	
	public BigDecimal getCantidad() {
		return Cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		Cantidad = cantidad;
	}
	public Material(TiposMaterial id, BigDecimal cantidad) {
		this.id = id;
		Cantidad = cantidad;
	}
	
}
