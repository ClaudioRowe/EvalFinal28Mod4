package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IUsuarioCRUD;
import com.planificador.modelo.Usuario;

public class UsuarioDAO implements IUsuarioCRUD {

	@Override
	public boolean crearUsuario(Usuario user) {

		String sql = "INSERT INTO usuario (usuario, nombre, apellido, email, telefono, "
				+ "password, cod_pais, cod_zona) VALUES (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getNombre());
			ps.setString(3, user.getApellido());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelefono());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getPais());
			ps.setString(8, user.getZona_horaria());

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
	public Usuario obtenerUsuario(int id) {

		String sql = "SELECT * FROM usuario WHERE cod_usuario=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Usuario user = new Usuario();

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				user.setId(id);
				user.setUsername(rs.getString("usuario"));
				user.setNombre(rs.getString("nombre"));
				user.setApellido(rs.getString("apellido"));
				user.setEmail(rs.getString("email"));
				user.setTelefono(rs.getString("telefono"));
				user.setPassword(rs.getString("password"));
				user.setPais(rs.getString("cod_pais"));
				user.setZona_horaria(rs.getString("cod_zona"));

			}

			rs.close();
			ps.close();

			return user;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@Override
	public boolean modificarUsuario(Usuario user) {

		String sql = "UPDATE usuario SET usuario=?, nombre=?, apellido=?, email=?, telefono=?, "
				+ "password=?, cod_pais=?, cod_zona=? WHERE cod_usuario=?";
		Connection con = null;
		PreparedStatement ps;

		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getNombre());
			ps.setString(3, user.getApellido());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelefono());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getPais());
			ps.setString(8, user.getZona_horaria());
			ps.setInt(9, user.getId());

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
	public boolean verificarUsuario(String usuario, String password) {
		
		String sql = "SELECT usuario, password FROM usuario where usuario=? and password=?";
		Connection con = null;
		
		try {
			con = ConexionBD.conectar();
			
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, usuario);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	        	return true;
	        } 
		
		
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return false;
		
	}

}
