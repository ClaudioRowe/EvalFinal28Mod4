package com.planificador.interfaces;

import java.util.List;

import com.planificador.modelo.Rutina;

public interface IRutinaCRUD {
	
	// Crear una rutina
	public boolean crearRutina(Rutina rutina);
	
	// Obtener una rutina de un usuario
	public Rutina obtenerRutina(int id_rutina);
	
	// Obtener la lista de rutinas de un usuario
	public List<Rutina> obtenerListaRutinas(int id_usuario);
	
	// Modifica una rutina
	public boolean modificarRutina(Rutina rutina);
	
	// Cambia el estado de una rutina a "Eliminado"
	public boolean deshabilitarRutina(int id_rutina);

}
