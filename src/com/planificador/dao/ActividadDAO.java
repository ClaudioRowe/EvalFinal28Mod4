package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IActividadCRUD;
import com.planificador.modelo.Actividad;


public class ActividadDAO implements IActividadCRUD {

	@Override
	public boolean crearActividad(Actividad actividad, int id_usuario) {
		
		String sql = "INSERT INTO actividad (cod_usuario, descripcion_act, detalle_act, fecha_act, categoria_act, "
				+ "estado_act) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			ps.setString(2, actividad.getDescripcion());
			ps.setString(3, actividad.getDetalle());
			ps.setLong(4, actividad.getFecha());
			ps.setString(5, actividad.getCategoria());
			ps.setString(6, actividad.getEstado());


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
	public Actividad obtenerActividad(int id_actividad) {
		
		String sql = "SELECT * FROM actividad WHERE cod_act=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Actividad actividad = new Actividad();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_actividad);

			rs = ps.executeQuery();

			if (rs.next()) {

				actividad.setId(id_actividad);
				actividad.setDescripcion(rs.getString("descripcion_act"));
				actividad.setDetalle(rs.getString("deatlle_act"));
				actividad.setFecha(rs.getLong("fecha_act"));
				actividad.setCategoria(rs.getString("categoria_act"));
				actividad.setEstado(rs.getString("estado_act"));

			}

			rs.close();
			ps.close();

			return actividad;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}
		

	@Override
	public List<Actividad> obtenerListaActividades(int id_usuario) {
		
		String sql = "SELECT * FROM actividad WHERE cod_usuario=? AND estado_act!=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		List<Actividad> listaActividad = new ArrayList<>();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			ps.setString(2, "ELIMINADO");

			rs = ps.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();

				actividad.setId(rs.getInt("cod_act"));
				actividad.setDescripcion(rs.getString("descripcion_act"));
				actividad.setDetalle(rs.getString("deatlle_act"));
				actividad.setFecha(rs.getLong("fecha_act"));
				actividad.setCategoria(rs.getString("categoria_act"));
				actividad.setEstado(rs.getString("estado_act"));
				
				listaActividad.add(actividad);
			}

			rs.close();
			ps.close();

			return listaActividad;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
		
	}

	@Override
	public List<Actividad> obtenerActividadesPorFecha(int id_usuario, long fecha) {
		
		String sql = "SELECT * FROM actividad WHERE cod_usuario=? AND estado_act!=? AND fecha_act=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		List<Actividad> listaActividad = new ArrayList<>();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			ps.setString(2, "ELIMINADO");
			ps.setLong(3, fecha);

			rs = ps.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();

				actividad.setId(rs.getInt("cod_act"));
				actividad.setDescripcion(rs.getString("descripcion_act"));
				actividad.setDetalle(rs.getString("deatlle_act"));
				actividad.setFecha(rs.getLong("fecha_act"));
				actividad.setCategoria(rs.getString("categoria_act"));
				actividad.setEstado(rs.getString("estado_act"));
				
				listaActividad.add(actividad);
			}

			rs.close();
			ps.close();

			return listaActividad;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
		
	}

	@Override
	public List<Actividad> obtenerActividadesPorCategoria(int id_usuario, String categoria) {
	
		String sql = "SELECT * FROM actividad WHERE cod_usuario=? AND estado_act!=? AND categoria_act=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		List<Actividad> listaActividad = new ArrayList<>();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			ps.setString(2, "ELIMINADO");
			ps.setString(3, categoria);

			rs = ps.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();

				actividad.setId(rs.getInt("cod_act"));
				actividad.setDescripcion(rs.getString("descripcion_act"));
				actividad.setDetalle(rs.getString("deatlle_act"));
				actividad.setFecha(rs.getLong("fecha_act"));
				actividad.setCategoria(rs.getString("categoria_act"));
				actividad.setEstado(rs.getString("estado_act"));
				
				listaActividad.add(actividad);
			}

			rs.close();
			ps.close();

			return listaActividad;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
		
	}

	@Override
	public List<Actividad> obtenerActividadesPorEstado(int id_usuario, String estado) {
		
		String sql = "SELECT * FROM actividad WHERE cod_usuario=? AND estado_act=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		List<Actividad> listaActividad = new ArrayList<>();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			ps.setString(2, estado);

			rs = ps.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();

				actividad.setId(rs.getInt("cod_act"));
				actividad.setDescripcion(rs.getString("descripcion_act"));
				actividad.setDetalle(rs.getString("deatlle_act"));
				actividad.setFecha(rs.getLong("fecha_act"));
				actividad.setCategoria(rs.getString("categoria_act"));
				actividad.setEstado(rs.getString("estado_act"));
				
				listaActividad.add(actividad);
			}

			rs.close();
			ps.close();

			return listaActividad;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
		
	}

	@Override
	public boolean modificarActividad(Actividad actividad) {
		
		String sql = "UPDATE actividad SET descripcion_act=?, detalle_act=?, fecha_act=?, categoria_act=?, "
				+ "estado_act=? WHERE cod_act=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, actividad.getDescripcion());
			ps.setString(2, actividad.getDetalle());
			ps.setLong(3, actividad.getFecha());
			ps.setString(4, actividad.getCategoria());
			ps.setString(5, actividad.getEstado());
			ps.setInt(6, actividad.getId());


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
	public boolean deshabilitarActividad(int id_actividad) {
		
		String sql = "UPDATE actividad SET estado_act=? WHERE cod_act=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, "ELIMINADO");
			ps.setInt(2, id_actividad);


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
	public int obtenerUltimoId() {
		String sql = "SELECT MAX(cod_act) FROM actividad";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		int id = 0;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {

				id = rs.getInt(1);
				
			}

			rs.close();
			ps.close();

		} catch (Exception e) {

			System.out.println(e);

		}

		return id;
	}

	@Override
	public boolean moverActividad(int id, String estado) {
		
		String sql = "UPDATE actividad SET estado_act=? WHERE cod_act=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, estado);
			ps.setInt(2, id);


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
