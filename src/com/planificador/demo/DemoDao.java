package com.planificador.demo;

import com.planificador.dao.UsuarioDAO;
import com.planificador.modelo.Usuario;

public class DemoDao {

	public static void main(String[] args) {
		
		UsuarioDAO userdao = new UsuarioDAO();
		Usuario u = new Usuario(1, "holamundo", "Hola", "Mundo", "hm@hm.com", "91111111", "hola12345", "BOL", "UTC-04:00");
		boolean status = userdao.modificarUsuario(u);
		Usuario user = userdao.obtenerUsuario(1);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getNombre());
		System.out.println(user.getApellido());
		System.out.println(user.getEmail());
		System.out.println(user.getTelefono());
		System.out.println(user.getPais());
		System.out.println(user.getZona_horaria());

	}

}
