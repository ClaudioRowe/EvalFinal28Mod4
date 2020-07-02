package com.planificador.interfaces;

import java.util.List;

import com.planificador.modelo.Actividad;

public interface IActividadCRUD {
	
	// Crear una actividad
	public boolean crearActividad(Actividad actividad, int id_usuario);
	
	// Obtener una actividad de un usuario
	public Actividad obtenerActividad(int id_actividad);
	
	// Obtener la lista de actividades de un usuario
	public List<Actividad> obtenerListaActividades(int id_usuario);
	
	// Obtener la lista de actividades de un usuario en una fecha espec�fica
	public List<Actividad> obtenerActividadesPorFecha(int id_usuario, long fecha);
		
	// Obtener la lista de actividades de un usuario de una categor�a espec�fica
	public List<Actividad> obtenerActividadesPorCategoria(int id_usuario, String categoria);
	
	// Obtener la lista de actividades de un usuario que tengan un estado espec�fico
	public List<Actividad> obtenerActividadesPorEstado(int id_usuario, String estado);
	
	// Modifica una actividad
	public boolean modificarActividad(Actividad actividad);
	
	// Cambia el estado de una actividad a "Eliminado"
	public boolean deshabilitarActividad(int id_actividad);

	// Obtiene el id de la �ltima actividad ingresada
	public int obtenerUltimoId();
	
	// Mueve una actividad y cambia su estado
	public boolean moverActividad(int id, String estado);
	
}
