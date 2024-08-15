package javaWebAssignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Multiply extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = 0;
		String multi = req.getParameter("do");
		if("Multiply".equals(multi)) {
			k = i * j;
		}
		else if("Addition".equals(multi)) {
			k = i + j;
		}
		else if("Subtraction".equals(multi)) {
			k = i - j;
		}
		else if("Division".equals(multi)) {
			if(j>0) {
			 k = i / j;
			}
		}
//		switch (multi) {
//		case "+":
//			k = i+j;
//			break;
//		case "-":
//			k = i -j;
//			break;
//		case "*":
//			k = i*j ;
//			break;
//		case "/":
//			if(j > 0) {
//			k = i/j;
//			break;
//			}
//			else {
//				PrintWriter obj = res.getWriter();
//				obj.println("The division cannot possible with 0 ");
//			}
//		}
		System.out.println("The multiplied value :"+k);
		PrintWriter obj = res.getWriter();
		obj.println("The multiplied value :" + k);
	}
}
