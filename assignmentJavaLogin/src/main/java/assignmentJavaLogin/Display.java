package assignmentJavaLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Display extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException{
		String pass= (String) req.getAttribute("password");
		String user = (String)req.getAttribute("username");
		PrintWriter obj = res.getWriter();
		
//		HttpSession session = req.getSession();
//		session.setAttribute("key", user+"");
		
		
//		if(pass.equals("Servlet")) {
////			obj.print("Welcome Servlet !" );
////			res.sendRedirect("SessionAccept");
//		}
//		else {
//			obj.print("Incorrect Failed !");
//			res.sendRedirect("Login.html");
//			
//		}
		Cookie ck1 = new Cookie("user",user+"");
		Cookie ck2 = new Cookie("pass", pass +"");
		res.addCookie(ck2);
		res.addCookie(ck1);
		res.sendRedirect("SessionAccept");
		
	
	}
}
