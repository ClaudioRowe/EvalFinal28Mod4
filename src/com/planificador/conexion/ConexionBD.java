package com.planificador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

	private static Connection con;
	private static String driver = DatosConexion.DRIVER;
	private static String url = DatosConexion.URL;
	private static String user = DatosConexion.USER;
	private static String pass = DatosConexion.PASS;

	private ConexionBD() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	}
	
	public static Connection conectar() {
		
		if (con == null) {
			
			new ConexionBD();
			
		}
		
		return con;
		
	}
	
}
