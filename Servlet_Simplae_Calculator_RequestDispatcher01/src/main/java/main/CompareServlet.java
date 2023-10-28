package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/add")
public class CompareServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.println("<html><body><center><h1>");
		try {
			Float f1 = Float.parseFloat(req.getParameter("first"));
			Float f2 = Float.parseFloat(req.getParameter("second"));
			if (f1 > f2 || f2 > f1) {
				pw.println("Greater :: " + f1);
			} else {
				pw.println("Smaller :: " + f2);
			}
			res.setContentType("text/html");
		} catch (NumberFormatException e) {
			pw.println("Enter in Number Formats only....");
		}
		pw.println("</h1></center></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("calculate.html");
		rd.include(req, res);
	}//service
}//class