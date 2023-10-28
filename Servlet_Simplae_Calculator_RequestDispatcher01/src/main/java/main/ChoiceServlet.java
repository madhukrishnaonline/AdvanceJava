package main;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String v1 = req.getParameter("s1");

		if (v1.equals("Add")) {
			RequestDispatcher rd = req.getRequestDispatcher("add");
			rd.forward(req, res);
		} else if (v1.equals("Sub")) {
			RequestDispatcher rd = req.getRequestDispatcher("sub");
			rd.forward(req, res);
		} else if (v1.equals("Mul")) {
			RequestDispatcher rd = req.getRequestDispatcher("mul");
			rd.forward(req, res);
		} else if (v1.equals("Div")) {
			RequestDispatcher rd = req.getRequestDispatcher("div");
			rd.forward(req, res);
		} else if (v1.equals("Compare")) {
			RequestDispatcher rd = req.getRequestDispatcher("mod");
			rd.forward(req, res);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("compare");
			rd.forward(req, res);
		}
	}//service
}//class