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
 * Servlet implementation class EditarActividadServlet
 */
@WebServlet("/editaractividad")
public class EditarActividadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarActividadServlet() {
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
		String descripcion = request.getParameter("descripcion");
		String detalles = request.getParameter("detalles");
		String fechaString = request.getParameter("fecha");
		String categoria = request.getParameter("categoria");
		int id = Integer.parseInt(idString);
		long fecha = Long.parseLong(fechaString);
		
		Actividad actividad = new Actividad(id, descripcion, detalles, fecha, categoria, "Por hacer");
		
		ActividadDAO actdao = new ActividadDAO();
		boolean status = actdao.modificarActividad(actividad);
		
		if (status) {
			
			response.getWriter().write("ok");
			
		} else {
			
			response.getWriter().write("error");
			
		}
	}

}
