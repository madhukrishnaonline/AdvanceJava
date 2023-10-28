package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetURL
 */
@WebServlet("/set")
public class SetURL extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetURL() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
       String s1 = request.getParameter("book1");
       String s2 = request.getParameter("book2");
       String s3 = request.getParameter("book3");
       PrintWriter pw = response.getWriter();
       pw.println("<html><body><center>");
       pw.println("<h1>Your Books Are Added to Cart</h1>");
       pw.println
        ("<a href=get?book1="+s1+"&book2="+s2+"&book3="+s3+">View Cart</a>");
       pw.println("</center></body></html>");
	}

}
