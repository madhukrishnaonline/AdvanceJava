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
@WebServlet("/sub")
public class SubtractionServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			Float f1 = Float.parseFloat(req.getParameter("first"));
			Float f2 = Float.parseFloat(req.getParameter("second"));
			Float f3 = f1 - f2;
			PrintWriter pw = res.getWriter();
			pw.println("Sub :: " + f3);
			res.setContentType("text/html");
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("calculate.html");
		try {
			rd.include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
	}//service
}//class