package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IContactoCRUD;
import com.planificador.modelo.InfoContacto;

public class ContactoDao implements IContactoCRUD {
	
	public int guardarInfoContacto(InfoContacto info) {
		
		int status = 0;
		Connection con = null;
		PreparedStatement ps;
		 
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement("INSERT INTO contacto(nombres_con,apellidos_con,email_con,telefono_con,mensaje)"
            		+ " VALUES (?,?,?,?,?)");  
            ps.setString(1,info.getNombre());  
            ps.setString(2,info.getApellido());  
            ps.setString(3,info.getEmail());  
            ps.setString(4,info.getTelefono());
            ps.setString(5,info.getMensaje());  
              
            status=ps.executeUpdate();
              
            ps.close();
            
        } catch (Exception ex){
        	
        	ex.printStackTrace();
        	
        }  
          
        return status;
		
	}
	
}
