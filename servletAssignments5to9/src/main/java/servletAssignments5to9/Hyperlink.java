package servletAssignments5to9;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hyper")
public class Hyperlink extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException{
		PrintWriter obj = res.getWriter();
		res.setContentType("text/html");
		obj.println("<html><body>");
		obj.println("<h1>Hello this is separate file for checking "
				+ "the hyperlink to servlet connection </h1>");
		obj.println("</body></html>");
	}
}
