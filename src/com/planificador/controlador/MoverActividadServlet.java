package com.planificador.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planificador.dao.ActividadDAO;
import com.planificador.modelo.Actividad;

/**
 * Servlet implementation class MoverActividadServlet
 */
@WebServlet("/moveractividad")
public class MoverActividadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoverActividadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String idString = request.getParameter("id");
		String estado = request.getParameter("estado");
		
		int id = Integer.parseInt(idString);
		estado = estado.toUpperCase();
		
		ActividadDAO actdao = new ActividadDAO();
		boolean status = actdao.moverActividad(id, estado);
		
		if (status) {
			
			response.getWriter().write("ok");
			
		} else {
			
			response.getWriter().write("error");
			
		}
		
	}

}
