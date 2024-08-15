package servletAssignments5to9;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FIleDownload extends HttpServlet{
	private static final String UPLOAD_DIR = "uploads";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException , ServletException{
		String filename = req.getParameter("file");
		if (filename == null || filename.trim().isEmpty()) {
            res.sendError(res.SC_BAD_REQUEST, "File name is missing");
            return;
        }
		String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR + File.separator + filename;
        File file = new File(filePath);

        if (!file.exists()) {
            res.sendError(res.SC_NOT_FOUND, "File not found");
            return;
        }

        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        res.setContentLengthLong(file.length());
        
        try (FileInputStream in = new FileInputStream(file);
                OutputStream out = res.getOutputStream()) {
               byte[] buffer = new byte[1024];
               int bytesRead;
               while ((bytesRead = in.read(buffer)) != -1) {
                   out.write(buffer, 0, bytesRead);
               }
         }
	}
}
