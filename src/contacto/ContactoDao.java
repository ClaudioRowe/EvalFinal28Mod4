package contacto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactoDao {

	public static Connection getConnection() {
		
		Connection con=null;
		
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logintrabajo", "root", "root");
            
        }catch(Exception e){System.out.println(e);}  
        return con;  
		
	}
	
	public static int save(InfoContacto info) {
		
		 int status=0;
		 
	        try{
	            Connection con = ContactoDao.getConnection();
	            PreparedStatement ps=con.prepareStatement(
	                         "insert into contacto(nombres,apellidos,e_mail,telefono, mensaje) values (?,?,?,?,?)");  
	            ps.setString(1,info.getNombre());  
	            ps.setString(2,info.getApellido());  
	            ps.setString(3,info.getEmail());  
	            ps.setString(4,info.getTelefono());
	            ps.setString(5,info.getMensaje());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;
		
	}
	
}
