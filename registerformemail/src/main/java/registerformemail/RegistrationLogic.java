package registerformemail;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegistrationLogic extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException {
		String firstname = req.getParameter("name");
		String midNmae = req.getParameter("middle");
		String lastName = req.getParameter("last");
		String Log = req.getParameter("desired");
		String password = req.getParameter("pass");
		String confPass = req.getParameter("password");
		String Loc = req.getParameter("loc");
		String education = req.getParameter("edu");
		String Phone = req.getParameter("phone");
		
		PrintWriter obj = res.getWriter();
		boolean match = password != null && password.equals(confPass);
		 res.setContentType("text/html");
		obj.println("<html><body>");
		if (match) {
			obj.println("<h2>Registration Successful !</h2>");
			obj.println("<p>Welcome "+firstname + ""+lastName+"</p>");
			obj.println("</body></html>");
		}
		else {
			obj.println("<h1>Registration Failed!</h1>");
            obj.println("<p>Passwords do not match. Please go back and try again.</p>");
            obj.println("</body></html>");
		}
		
	}
}
