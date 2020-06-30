package com.planificador.modelo;

public class Actividad {

	private int id;
	private String descripcion;
	private String detalle;
	private long fecha;
	private String categoria;
	private String estado;

	public Actividad() {
		super();
	}

	public Actividad(String descripcion, String detalle, long fecha, String categoria, String estado) {
		super();
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.fecha = fecha;
		this.categoria = categoria;
		this.estado = estado;
	}

	public Actividad(int id, String descripcion, String detalle, long fecha, String categoria, String estado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.fecha = fecha;
		this.categoria = categoria;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
