package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetURL() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("h-1");
		String s2 = request.getParameter("h-2");
		String s3 = request.getParameter("h-3");
		String s4 = request.getParameter("h-4");
		String s5 = request.getParameter("h-5");

		HttpSession hs = request.getSession();
		hs.setAttribute("h-1",s1);
		hs.setAttribute("h-2",s2);
		hs.setAttribute("h-3",s3);
		hs.setAttribute("h-4",s4);
		hs.setAttribute("h-5",s5);

		PrintWriter pw = response.getWriter();
		String s = response.encodeURL("get");
		pw.println("<html><body><center>");
		pw.println("<a href=" + s + ">View Hostel's</a>");
		pw.println("</center></body></html>");
	}
}//class