package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IActividadRutinaCRUD;
import com.planificador.modelo.ActividadRutina;

public class ActividadRutinaDAO implements IActividadRutinaCRUD{

	@Override
	public boolean crearActRutina(ActividadRutina actRutina) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps;

        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement("INSERT INTO rutina(desc_act_rutina=? ,detalle_act_rutina=?, cat_act_rutina=?)"
            		+ " VALUES (?,?,?)");  
            ps.setString(1,actRutina.getDescripcion());  
            ps.setString(2,actRutina.getDetalle());  
            ps.setString(3,actRutina.getCategoria());

            for (int i=0; i<7; i++) {

            }

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
	public ActividadRutina obtenerActRutina(int id_act_rutina) {
		String sql = "SELECT * FROM usuario WHERE cod_rutina=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		ActividadRutina actRutina = new ActividadRutina();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_act_rutina);

			rs = ps.executeQuery();

			while (rs.next()) {

				actRutina.setId(id_act_rutina);
				actRutina.setDescripcion(rs.getString("desc_act_rutina"));
				actRutina.setDetalle(rs.getString("detalle_act_rutina"));
				actRutina.setCategoria(rs.getString("descripcion_rutina"));

			}

			rs.close();
			ps.close();

			return actRutina;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@Override
	public List<ActividadRutina> obtenerListaActRutina(int id_rutina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActividadRutina> obtenerListaActRutinaPorCategoria(int id_rutina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarActRutina(int id_act_rutina) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarActRutina(int id_act_rutina) {
		// TODO Auto-generated method stub
		return false;
	}

}