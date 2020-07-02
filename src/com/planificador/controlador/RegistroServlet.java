package com.planificador.controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planificador.dao.PaisDAO;
import com.planificador.dao.UsuarioDAO;
import com.planificador.modelo.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String usuario = request.getParameter("ingreso");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String password = request.getParameter("password");
		String pais = request.getParameter("pais");
		
		
		PaisDAO paisDao = new PaisDAO();
		
		String zona_horaria = paisDao.integrarZona(pais);
		
		UsuarioDAO crearUsuario = new UsuarioDAO();
			
		Usuario user = new Usuario(usuario, nombre, apellido, email, telefono, password,
				pais, zona_horaria);
		
		crearUsuario.crearUsuario(user);
			
	}
	
}
