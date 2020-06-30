package com.planificador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int id;
	private String username;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String password;
	private String pais;
	private String zona_horaria;
	private List<Actividad> actividades;
	private List<Rutina> rutinas;
	
	public Usuario() {
		super();
		this.actividades = new ArrayList<>();
		this.rutinas = new ArrayList<>();
	}
	
	public Usuario(String username, String nombre, String apellido, String email, String telefono, String password,
			String pais, String zona_horaria) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.pais = pais;
		this.zona_horaria = zona_horaria;
		this.actividades = new ArrayList<>();
		this.rutinas = new ArrayList<>();
	}

	public Usuario(String username, String nombre, String apellido, String email, String telefono, String password,
			String pais, String zona_horaria, List<Actividad> actividades, List<Rutina> rutinas) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.pais = pais;
		this.zona_horaria = zona_horaria;
		this.actividades = actividades;
		this.rutinas = rutinas;
	}
	
	

	public Usuario(int id, String username, String nombre, String apellido, String email, String telefono,
			String password, String pais, String zona_horaria) {
		super();
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.pais = pais;
		this.zona_horaria = zona_horaria;
		this.actividades = new ArrayList<>();
		this.rutinas = new ArrayList<>();
	}

	public Usuario(int id, String username, String nombre, String apellido, String email, String telefono,
			String password, String pais, String zona_horaria, List<Actividad> actividades, List<Rutina> rutinas) {
		super();
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.pais = pais;
		this.zona_horaria = zona_horaria;
		this.actividades = actividades;
		this.rutinas = rutinas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getZona_horaria() {
		return zona_horaria;
	}

	public void setZona_horaria(String zona_horaria) {
		this.zona_horaria = zona_horaria;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}
	
	
	
	
	
	
}
