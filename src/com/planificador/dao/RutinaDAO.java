package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IRutinaCRUD;
import com.planificador.modelo.Rutina;

public class RutinaDAO implements IRutinaCRUD {


	@Override
	public boolean crearRutina(Rutina rutina) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps;
		 
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement("INSERT INTO rutina(nombre_rutina=? ,decripcion_rutina=?, inicio_rutina=?, fin_rutina=?, estado_rutina=?)"
            		+ " VALUES (?,?,?,?,?)");  
            ps.setString(1,rutina.getNombre());  
            ps.setString(2,rutina.getDescripcion());  
            ps.setLong(3,rutina.getFecha_inicio());  
            ps.setLong(4,rutina.getFecha_fin());
            ps.setString(5,rutina.getEstado());  
              
            status=ps.executeUpdate();
              
            ps.close();
            
            if (status == 1) {
            
            return true;
            	
            }
            
        } catch (Exception ex){
        	
        	ex.printStackTrace();
        	
        }  
          
        return false;
		
	}

	@Override
	public Rutina obtenerRutina(int id) {
		String sql = "SELECT * FROM usuario WHERE cod_rutina=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Rutina rutina = new Rutina();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				rutina.setId(id);
				rutina.setNombre(rs.getString("nombre_rutina"));
				rutina.setDescripcion(rs.getString("descripcion_rutina"));
				rutina.setFecha_inicio(rs.getLong("inicio_rutina"));
				rutina.setFecha_fin(rs.getLong("fin_rutina"));
				rutina.setEstado(rs.getString("estado_rutina"));

			}

			rs.close();
			ps.close();

			return rutina;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@Override
	public List<Rutina> obtenerListaRutinas(int id_usuario) {
		String sql = "SELECT * FROM usuario WHERE cod_rutina=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		List<Rutina> listaRutinas = new ArrayList<>();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			while (rs.next()) {
				Rutina rutina = new Rutina();

				rutina.setId(rs.getInt("cod_rutina"));
				rutina.setNombre(rs.getString("nombre_rutina"));
				rutina.setDescripcion(rs.getString("descripcion_rutina"));
				rutina.setFecha_inicio(rs.getLong("inicio_rutina"));
				rutina.setFecha_fin(rs.getLong("fin_rutina"));
				rutina.setEstado(rs.getString("estado_rutina"));
				
				listaRutinas.add(rutina);
			}

			rs.close();
			ps.close();

			return listaRutinas;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}
	

	@Override
	public boolean modificarRutina(Rutina rutina) {
		String sql = "UPDATE rutina SET nombre_rutina=?, descripcion_rutina=?, inicio_rutina=?, fin_rutina=?, estado_rutina=? WHERE cod_rutina=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, rutina.getNombre());
			ps.setString(2, rutina.getDescripcion());
			ps.setLong(3, rutina.getFecha_inicio());
			ps.setLong(4, rutina.getFecha_fin());
			ps.setString(5, rutina.getEstado());
			ps.setInt(6, rutina.getId());

			int status = ps.executeUpdate();

			ps.close();

			if (status == 1) {

				return true;

			}

		} catch (Exception e) {

			System.out.println(e);

		}

		return false;

	}

	@Override
	public boolean deshabilitarRutina(int id_rutina) {
		
		String sql = "UPDATE rutina SET estado_rutina=? WHERE cod_rutina=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, "ELIMINADO");
			ps.setInt(2, id_rutina);

			int status = ps.executeUpdate();

			ps.close();

			if (status == 1) {

			return true;

			}

		} catch (Exception e) {

			System.out.println(e);

		}

		return false;

	}
}




