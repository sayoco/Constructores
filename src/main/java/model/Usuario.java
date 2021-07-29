package model;

public class Usuario {
	private String id;
	private String nombre;
	private Perfil perfil;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Usuario(String id, String nombre, Perfil perfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.perfil = perfil;
	}
	
}
