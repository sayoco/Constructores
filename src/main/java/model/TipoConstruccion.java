package model;

import java.math.BigDecimal;

public class TipoConstruccion {
	private String id;
	private String tipo;
	private BigDecimal ce;
	private BigDecimal gr;
	private BigDecimal ar;
	private BigDecimal ma;
	private BigDecimal ad;
	private Integer duracion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getCe() {
		return ce;
	}
	public void setCe(BigDecimal ce) {
		this.ce = ce;
	}
	public BigDecimal getGr() {
		return gr;
	}
	public void setGr(BigDecimal gr) {
		this.gr = gr;
	}
	public BigDecimal getAr() {
		return ar;
	}
	public void setAr(BigDecimal ar) {
		this.ar = ar;
	}
	public BigDecimal getMa() {
		return ma;
	}
	public void setMa(BigDecimal ma) {
		this.ma = ma;
	}
	public BigDecimal getAd() {
		return ad;
	}
	public void setAd(BigDecimal ad) {
		this.ad = ad;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public TipoConstruccion(String id
			, String tipo
			, BigDecimal ce
			, BigDecimal gr
			, BigDecimal ar
			, BigDecimal ma
			, BigDecimal ad
			, Integer duracion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.ce = ce;
		this.gr = gr;
		this.ar = ar;
		this.ma = ma;
		this.ad = ad;
		this.duracion = duracion;
	}
		
}
