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
 * Servlet implementation class EliminarActividadServlet
 */
@WebServlet("/eliminaractividad")
public class EliminarActividadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarActividadServlet() {
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
		int id = Integer.parseInt(idString);
		
		ActividadDAO actdao = new ActividadDAO();
		boolean status = actdao.deshabilitarActividad(id);
		
		if (status) {
			
			response.getWriter().write("ok");
			
		} else {
			
			response.getWriter().write("error");
			
		}
		
	}

}
