package com.planificador.interfaces;

import java.util.List;

import com.planificador.modelo.Actividad;

public interface IActividadCRUD {
	
	// Crear una actividad
	public boolean crearActividad(Actividad actividad);
	
	// Obtener una actividad de un usuario
	public Actividad obtenerActividad(int id_actividad);
	
	// Obtener la lista de actividades de un usuario
	public List<Actividad> obtenerListaActividades(int id_usuario);
	
	// Obtener la lista de actividades de un usuario en una fecha específica
	public List<Actividad> obtenerActividadesPorFecha(int id_usuario);
		
	// Obtener la lista de actividades de un usuario de una categoría específica
	public List<Actividad> obtenerActividadesPorCategoria(int id_usuario);
	
	// Obtener la lista de actividades de un usuario que tengan un estado específico
	public List<Actividad> obtenerActividadesPorEstado(int id_usuario);
	
	// Modifica una actividad
	public boolean modificarActividad(Actividad actividad);
	
	// Cambia el estado de una actividad a "Eliminado"
	public boolean desabilitarActividad(int id_actividad);
	
}
