package com.planificador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Rutina {

	private int id;
	private String nombre;
	private String descripcion;
	private long fecha_inicio;
	private long fecha_fin;
	private String estado;
	private List<ActividadRutina> actividades;

	public Rutina() {
		super();
		this.actividades = new ArrayList<>();
	}

	public Rutina(String nombre, String descripcion, long fecha_inicio, long fecha_fin, String estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.actividades = new ArrayList<>();
	}

	public Rutina(String nombre, String descripcion, long fecha_inicio, long fecha_fin, String estado,
			List<ActividadRutina> actividades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.actividades = actividades;
	}

	public Rutina(int id, String nombre, String descripcion, long fecha_inicio, long fecha_fin, String estado,
			List<ActividadRutina> actividades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.actividades = actividades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(long fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public long getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(long fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ActividadRutina> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadRutina> actividades) {
		this.actividades = actividades;
	}

}
