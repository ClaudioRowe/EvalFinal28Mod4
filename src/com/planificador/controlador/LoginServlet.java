package com.planificador.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planificador.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginTrabajoGrupal
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String usuario = request.getParameter("ingreso");
		String password = request.getParameter("password");
		
		UsuarioDAO userdao = new UsuarioDAO();

		boolean isValido = userdao.verificarUsuario(usuario, password);
	        
        if (isValido) {
        	
        	Cookie ck = new Cookie("usuario", usuario);
        	ck.setMaxAge(180);
        	response.addCookie(ck);
        	response.sendRedirect("index.html");
        	
        } else {
        	
        	out.print("Usuario o contraseña incorrectos");
        	request.getRequestDispatcher("index.jsp").include(request, response);
        	
        }
	        
		out.close();
		
	}

}
