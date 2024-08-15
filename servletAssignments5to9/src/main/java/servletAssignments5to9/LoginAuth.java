package servletAssignments5to9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAuth extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws IOException , ServletException 
	{
		String user= (String)req.getParameter("user");
		
		String pass = (String)req.getParameter("pass");
		
		if("Admin".equals(user)&& "Servlet".equals(pass)) {
			HttpSession session = req.getSession();
			
			session.setAttribute("username", user);
			session.setMaxInactiveInterval(1*60);
			
			 if (session.getAttribute("hasVisitedBefore") == null) {
	                session.setAttribute("hasVisitedBefore", Boolean.FALSE);
	            }
			 
			res.sendRedirect("Session");
		}
		else {
			res.sendRedirect("Home.html?error=incorrect");
		}
	}
}
