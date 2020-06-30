package com.planificador.modelo;

import java.util.Calendar;

public class ActividadRutina {

	private int id;
	private String descripcion;
	private String detalle;
	private String categoria;
	private Calendar[] horasInicio = new Calendar[7];
	private Calendar[] horasFin = new Calendar[7];

	public ActividadRutina() {
		super();
		inicializarHoras();
	}

	public ActividadRutina(String descripcion, String detalle, String categoria, Calendar[] horasInicio,
			Calendar[] horasFin) {
		super();
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.categoria = categoria;
		this.horasInicio = horasInicio;
		this.horasFin = horasFin;
		inicializarHoras();
	}

	public ActividadRutina(int id, String descripcion, String detalle, String categoria, Calendar[] horasInicio,
			Calendar[] horasFin) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.categoria = categoria;
		this.horasInicio = horasInicio;
		this.horasFin = horasFin;
		inicializarHoras();
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Calendar[] getHorasInicio() {
		return horasInicio;
	}

	public void setHorasInicio(Calendar[] horasInicio) {
		this.horasInicio = horasInicio;
	}

	public Calendar[] getHorasFin() {
		return horasFin;
	}

	public void setHorasFin(Calendar[] horasFin) {
		this.horasFin = horasFin;
	}

	private void inicializarHoras() {
		
		for (int i = 0; i < this.horasInicio.length; i++) {

			horasInicio[i] = Calendar.getInstance();

		}

		for (int i = 0; i < this.horasFin.length; i++) {

			horasFin[i] = Calendar.getInstance();

		}
		
	}

}
