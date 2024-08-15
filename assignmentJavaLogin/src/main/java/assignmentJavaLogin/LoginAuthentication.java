package assignmentJavaLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAuthentication extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws IOException , ServletException 
	{
		String user= (String)req.getParameter("username");
		String pass = (String)req.getParameter("password");
		
		
		req.setAttribute("password", pass);
		req.setAttribute("username", user);
		RequestDispatcher rd = req.getRequestDispatcher("dist");
		rd.forward(req, res);
		
//		Cookie ck1 = new Cookie("user",user+"");
//		Cookie ck2 = new Cookie("pass", pass +"");
//		res.addCookie(ck2);
//		res.addCookie(ck1);
//		res.sendRedirect("dist");
	}
}
