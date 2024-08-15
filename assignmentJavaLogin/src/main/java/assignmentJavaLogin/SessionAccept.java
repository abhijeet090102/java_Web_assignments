package assignmentJavaLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SessionAccept")
public class SessionAccept extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException , ServletException{
		
//		HttpSession session = req.getSession();
//		session.setMaxInactiveInterval(1*60);
//		String st = (String)session.getAttribute("key");
//		PrintWriter out = res.getWriter();
//		
//		out.println("Welcome to Servlet !" );
//		out.println("User is "+st);
//		System.out.print("User is "+st);
		
		PrintWriter obj = res.getWriter();
		String v1 ="",v2 ="";
		Cookie c[] = req.getCookies();
		for(Cookie ck:c) {
			if(ck.getName().equals("pass")) {
				v1 = (String)ck.getValue();
			}
			if(ck.getName().equals("user")) {
				v2 = ck.getValue().toString();
			}
		}
		if(v1.equals("Servlet") && v2.equals("Admin")) {
			
			obj.println("Welcome to Servlet !"+v2);
		}
		else {
			obj.println("Incorrect password !");
			res.sendRedirect("Login.html?error=incorrect");
		}
		
	}
}
