import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class Demo
 */
public class BookDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {  
        PrintWriter out = res.getWriter();  
        res.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
        	Class.forName("com.mysql.jdbc.Driver");   
        	Connection con=DriverManager.getConnection(  
        			"jdbc:mysql://localhost:3306/books","root","root");    
          
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from bookdemo");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>BookId</th><th>BookName</th><th>Amount</th><tr>");  
            while (rs.next()) 
            {  
               int n = rs.getInt("id");  
                String nm = rs.getString("name");  
                int s = rs.getInt("amount");   
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>"); 
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println(e);  
        }
       
}
}