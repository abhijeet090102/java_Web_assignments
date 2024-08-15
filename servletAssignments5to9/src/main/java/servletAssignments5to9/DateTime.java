package servletAssignments5to9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/currdate")
public class DateTime extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException {
		PrintWriter obj = res.getWriter();
		Date curdate = new Date();
		
		obj.println("<head><body>");
        obj.println("<meta http-equiv='refresh' content='1'>");
        obj.println("</head></body>");
        obj.println("<h2>Current Date and Time: "+curdate.toString()+"</h2>");
        obj.println("</body></html>");
	}
}
