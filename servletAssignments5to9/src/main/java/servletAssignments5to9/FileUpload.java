package servletAssignments5to9;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/upload")
@MultipartConfig
public class FileUpload extends HttpServlet{
	private static final String UPLOAD_DIR = "uploads";

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException , ServletException{
		Part filepart = req.getPart("file");
		
		String fileType = filepart.getContentType();
		String fileName = filepart.getSubmittedFileName();
		String filePath = getServletContext().getRealPath("")+File.separator + UPLOAD_DIR;
		File uploadDir = new File(filePath);
		PrintWriter obj = res.getWriter();
		
		
			
            if(!uploadDir.exists()) {
            	uploadDir.mkdir();
            }
            File file = new File(filePath + File.separator +fileName);
            filepart.write(file.getAbsolutePath());

            res.setContentType("text/html");
            obj.println("<!DOCTYPE html>");
            obj.println("<html><body>");
            obj.println("<h2>File Upload</h2>");
            obj.println("<p>File Name: " + fileName + "</p>");
            obj.println("<p>File Type: " + filepart.getContentType() + "</p>");
            obj.println("<p><a href='download?file=" + fileName + "'>Download the file</a></p>");
            obj.println("</body></html>");
		
	}
}
