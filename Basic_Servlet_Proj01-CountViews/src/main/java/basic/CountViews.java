package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountViews
 */
@WebServlet("/count")
public class CountViews extends HttpServlet {
	Integer count = 0;
	private static final long serialVersionUID = 1L;

	public CountViews() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		count++;
		PrintWriter pw = response.getWriter();
		pw.println("This Page Has been Viewed " + count + " times");
	}//doGet
}//class