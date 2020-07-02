package com.planificador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.planificador.conexion.ConexionBD;
import com.planificador.interfaces.IPaisCRUD;
import com.planificador.modelo.Pais;

public class PaisDAO implements IPaisCRUD {

	@Override
	public Pais obtenerPais(String cod_pais) {
		String sql = "SELECT * FROM pais WHERE cod_pais=?";
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Pais pais = new Pais();
		try {

			con = ConexionBD.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, cod_pais);

			rs = ps.executeQuery();

			if (rs.next()) {

				pais.setcod_pais(cod_pais);
				pais.setPais(rs.getString("pais"));
			}

			rs.close();
			ps.close();

			return pais;
			
		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@Override
	public List<Pais> obtenerListaPaises() {
			
			String sql = "SELECT * FROM pais";
			Connection con = null;
			PreparedStatement ps;
			ResultSet rs;
			List<Pais> listaPaises = new ArrayList<>();

			try {

				con = ConexionBD.conectar();
				ps = con.prepareStatement(sql);

				rs = ps.executeQuery();

				while (rs.next()) {
					Pais pais = new Pais();

					pais.setcod_pais(rs.getString("cod_pais"));
					pais.setPais(rs.getString("pais"));
					
					listaPaises.add(pais);
				}

				rs.close();
				ps.close();

				return listaPaises;

			} catch (Exception e) {

				System.out.println(e);

			}

			return null;
			
		}
	
		public String integrarZona(String codigo_pais) {
			
			String sql = "SELECT cod_zona FROM zona_horaria_pais WHERE cod_pais=?";
			Connection con = null;
			PreparedStatement ps;
			ResultSet rs;
			
			
			try {
	
				con = ConexionBD.conectar();
				ps = con.prepareStatement(sql);
				ps.setString(1, codigo_pais);
				String zona_horaria = "";
				rs = ps.executeQuery();

				if (rs.next()) {

					zona_horaria = rs.getString("cod_zona");

				}

				rs.close();
				ps.close();
		
		
				return zona_horaria;

			} catch (Exception e) {

				System.out.println(e);

			}

			return null;
	
		}
}