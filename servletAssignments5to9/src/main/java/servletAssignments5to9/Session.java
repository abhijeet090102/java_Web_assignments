package servletAssignments5to9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Session extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
	throws IOException{
		HttpSession session = req.getSession();
			
		PrintWriter obj = res.getWriter();
		
		if(session != null) {
			String username = (String)session.getAttribute("username");
			Boolean hasVisitedBefore = (Boolean) session.getAttribute("hasVisitedBefore");
			
			 
			obj.println("<html><head>");
            obj.println("<title>Session Page</title>");
            obj.println("<link rel='stylesheet' type='text/css' href='Home.css'>");
            obj.println("</head><body>");
            
//			obj.println("<html><body>");
			obj.println("<iframe src='currdate' style='border:none; width:100%; height:50px;'></iframe>");
				 if (username != null && hasVisitedBefore == null || !hasVisitedBefore) {
	              
	                    session.setAttribute("hasVisitedBefore", Boolean.TRUE);
	                   
	                    obj.println("<h1 class='title'>Welcome, " + username + "!</h1>");
	                    obj.println("<p>This is your first visit.</p>");
	                    obj.println("</body></html>");
	                    
	                } else {
	                    
	                    obj.println("<html><body>");
	                    obj.println("<h1 class='title'>Welcome back, " + username + "!</h1>");
	                    obj.println("<p>You have visited this page before.</p>");
	                    
	                    obj.println("</body></html>");
	                }
				 obj.println("<form action='upload' method='post' enctype='multipart/form-data'>");
                 obj.println("<input type='file' name='file' />");
                 obj.println("<input type='submit' value='Upload' />");
                 obj.println("</form>");
                 obj.println("</body></html>");
		}
		else {
			res.sendRedirect("login.html?error=sessionExpired"); 
		}
		

	}
}
