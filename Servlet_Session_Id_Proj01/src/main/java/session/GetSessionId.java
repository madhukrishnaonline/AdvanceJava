package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetSessionId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetSessionId() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=green text=white><center>");
		HttpSession hs = request.getSession();
		pw.println("Session Id :: " + hs.getId() + "<br>");
		pw.println("Created :: " + new Date(hs.getCreationTime()) + "<br>");
		pw.println("Last Accessed Time :: " + new Date(hs.getLastAccessedTime()) + "<br>");
		pw.println("Seconds till remain :: " + hs.getMaxInactiveInterval());
		pw.println("</center></body></html>");
	}//doGet
}//class