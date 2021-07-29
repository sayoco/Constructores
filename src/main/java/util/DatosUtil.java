package util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Ciudadela;
import model.Material;
import model.Perfil;
import model.SolicitudConstruccion;
import model.TipoConstruccion;
import model.Usuario;

public class DatosUtil {
	private static ArrayList<Usuario> usuarios;
    private static ArrayList<SolicitudConstruccion> solicitudes;
    private static ArrayList<Material> materiales;    
	private static Ciudadela ciudadela;
	private static DatosUtil instance = null;
	
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		DatosUtil.usuarios = usuarios;
	}

	public static ArrayList<SolicitudConstruccion> getSolicitudes() {
		return solicitudes;
	}

	public static void setSolicitudes(ArrayList<SolicitudConstruccion> solicitudes) {
		DatosUtil.solicitudes = solicitudes;
	}

	public static ArrayList<Material> getMateriales() {
		return materiales;
	}

	public static void setMateriales(ArrayList<Material> materiales) {
		DatosUtil.materiales = materiales;
	}

	public static Ciudadela getCiudadela() {
		return ciudadela;
	}

	public static void setCiudadela(Ciudadela delFuturo) {
		DatosUtil.ciudadela = delFuturo;
	}

	public static void setInstance(DatosUtil instance) {
		DatosUtil.instance = instance;
	}

	public static Usuario consultarUsuarioPorId(String idUsuario) {
		Optional<Usuario> usuario = 
				usuarios.stream()
								.filter(u -> u.getId().equals(idUsuario))
								.findAny();
		return usuario.isPresent() ? usuario.get() : null;
	}
	/*
	public static Material consultarMaterialPorId(TiposMaterial id) {
		Optional<Material> material = 
				materiales.stream()
								.filter(c -> c.getId().equals(id))
								.findAny();
		return material.isPresent() ? material.get() : null;
	}
	
	public static BigDecimal consultarCamtidadMaterialPorId(TiposMaterial id) {
		Optional<BigDecimal> cantidad = 
				materiales.stream()
								.filter(c -> c.getId().equals(id))
								.map(Material::getCantidad)
								.findAny();
		
		return cantidad.isPresent() ? cantidad.get() : null;
								
	}*/
	private DatosUtil() {
		Perfil arquitecto = new Perfil("arquitecto");
		Perfil ingeniero = new Perfil("ingeniero");
			
		usuarios = new ArrayList<Usuario>();
		Usuario elArquitecto = new Usuario("1","Andres",arquitecto);
		usuarios.add(elArquitecto);
		Usuario elIngeniero = new Usuario("2","Andres",ingeniero);
		usuarios.add(elIngeniero);
		
		
		materiales = new ArrayList<Material>();
		Material cemento = new Material(TiposMaterial.Cemento, new BigDecimal(100000));
		materiales.add(cemento);
		Material grava  = new Material(TiposMaterial.Grava , new BigDecimal(100000));
		materiales.add(grava);
		Material arena  = new Material(TiposMaterial.Arena , new BigDecimal(100000));
		materiales.add(arena);
		Material madera  = new Material(TiposMaterial.Madera , new BigDecimal(100000));
		materiales.add(madera);
		Material adobe  = new Material(TiposMaterial.Adobe , new BigDecimal(100000));
		materiales.add(adobe);
		
		solicitudes = new ArrayList<SolicitudConstruccion>();
		Date fechaInicio = Date.valueOf("2021-07-01");
		Date fechaTerminacion= Date.valueOf("2021-07-02");
		
		ciudadela = new Ciudadela("Ciudadela del Futuro"
								    ,fechaInicio
								    ,fechaTerminacion
								    ,solicitudes
								    ,materiales);
	}
	
	public static DatosUtil getInstance() {
		if (instance == null) {
			instance = new DatosUtil();
		}
		return instance;
	}
	public static void resetInstance() {
		instance = new DatosUtil();
	}
}
