package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetURL() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String s1 = request.getParameter("h-1"); String s2 =
		 * request.getParameter("h-2"); String s3 = request.getParameter("h-3"); String
		 * s4 = request.getParameter("h-4"); String s5 = request.getParameter("h-5");
		 */

		HttpSession hs = request.getSession();

		String s1 = (String) hs.getAttribute("h-1");
		String s2 = (String) hs.getAttribute("h-2");
		String s3 = (String) hs.getAttribute("h-3");
		String s4 = (String) hs.getAttribute("h-4");
		String s5 = (String) hs.getAttribute("h-5");

		PrintWriter pw = response.getWriter();

		pw.println("<html><body><center>");
		pw.println("<h1>Selected Hostel's</h1>");
		if (s1 != null) {
			pw.println(s1 + "<br>");
		}
		if (s2 != null) {
			pw.println(s2 + "<br>");
		}
		if (s3 != null) {
			pw.println(s3 + "<br>");
		}
		if (s4 != null) {
			pw.println(s4 + "<br>");
		}
		if (s5 != null) {
			pw.println(s5);
		}
		pw.println("</center></body></html>");
	}
}//class