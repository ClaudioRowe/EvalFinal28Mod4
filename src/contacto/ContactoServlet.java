package contacto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactoServlet
 */
@WebServlet("/contactoservlet")
public class ContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		InfoContacto info = new InfoContacto();
		info.setNombre(request.getParameter("nombre"));
		info.setApellido(request.getParameter("apellido"));
		info.setEmail(request.getParameter("e-mail"));
		info.setTelefono(request.getParameter("telefono"));
		info.setMensaje(request.getParameter("mensaje"));
		
		int status = ContactoDao.save(info);
		
		request.setAttribute("status", status);
		request.getRequestDispatcher("resultcontacto.jsp").forward(request, response);
		
		out.close();
		
	}

}
