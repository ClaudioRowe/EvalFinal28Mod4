package login;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTrabajoGrupal
 */
@WebServlet("/login")
public class LoginTrabajoGrupal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTrabajoGrupal() {
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

		Connection con = null;
		
		try {
			con = contacto.ContactoDao.getConnection();
			
	        PreparedStatement ps = con.prepareStatement(
	"select usuario, password from log where usuario=? and password=?");
	        ps.setString(1, usuario);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	        	Cookie ck = new Cookie("usuario", usuario);
	        	ck.setMaxAge(180);
	        	response.addCookie(ck);
	        	response.sendRedirect("index.html");
	        } else {
	        	out.print("Usuario o contrase�a incorrectos");
	        	request.getRequestDispatcher("index.jsp").include(request, response);
	        }
	        
	        con.close();
	        
		} catch (Exception e) {
			System.out.println(e);
		}
		
		out.close();
		
	}

}
