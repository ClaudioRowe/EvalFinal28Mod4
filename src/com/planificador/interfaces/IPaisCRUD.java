package com.planificador.interfaces;

import java.util.List;

import com.planificador.modelo.Pais;

public interface IPaisCRUD {

	public Pais obtenerPais(String cod_pais); 
	
	public List<Pais> obtenerListaPaises();
	
	public String integrarZona(String codigo_pais);
}
