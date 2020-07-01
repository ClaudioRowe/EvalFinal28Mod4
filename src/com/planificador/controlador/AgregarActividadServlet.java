package com.planificador.controlador;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planificador.modelo.Actividad;

/**
 * Servlet implementation class AgregarActividadServlet
 */
@WebServlet("/agregaractividad")
public class AgregarActividadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarActividadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text.html");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getContentType());
		String id_usuario = request.getParameter("id_usuario");
		
		String descripcion = request.getParameter("descripcion");
		String detalles = request.getParameter("detalles");
		String fechaString = request.getParameter("fecha");
		String categoria = request.getParameter("categoria");
		long fecha = Long.parseLong(fechaString);
		
		Actividad actividad = new Actividad(descripcion, detalles, fecha, categoria, "Por hacer");
		System.out.println(actividad.getDescripcion());
		System.out.println(actividad.getDetalle());
		System.out.println(actividad.getFecha());
		System.out.println(actividad.getCategoria());
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("Resultó");
		
	}

}
