package com.planificador.conexion;

import java.sql.Connection;

public class ConexionBD {

	private static Connection con;
	
	public static Connection conectar() {
		
		return con;
		
	}
	
}
