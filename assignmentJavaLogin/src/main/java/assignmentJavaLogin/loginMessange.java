package assignmentJavaLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class loginMessange extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String user= (String)req.getParameter("username");
		String pass = (String)req.getParameter("password");
		
		PrintWriter obj = res.getWriter();
		if(user.equals("admin") & pass.equals("Servlet")) {
			obj.println("Hello " + user);
		}
		else {
			obj.println("Login Failed !");
		}
	}
}
