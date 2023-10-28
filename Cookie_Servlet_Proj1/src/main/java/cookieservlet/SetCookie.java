package cookieservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public SetCookie() {}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			                               throws ServletException, IOException
	{
       String s1 = request.getParameter("book1");
       String s2 = request.getParameter("book2");
       String s3 = request.getParameter("book3");
       String s4 = request.getParameter("book4");
       
       if(s1!=null)
       {
    	   Cookie ck1 = new Cookie("book1",s1);
    	   response.addCookie(ck1);
       }
       if(s2!=null)
       {
    	   Cookie ck2 = new Cookie("book2",s2);
    	   response.addCookie(ck2);
       }
       if(s3!=null)
       {
    	   Cookie ck3 = new Cookie("book3",s3);
    	   response.addCookie(ck3);
       }
       if(s4!=null)
       {
    	   Cookie ck4 = new Cookie("book4",s4);
    	   response.addCookie(ck4);
       }
       
       PrintWriter pw = response.getWriter();
       pw.println("<html><body><center>");
       pw.println("<h1>Your Books Are added to cart</h1>");
       pw.println("<a href=get>Show Books</a>");
       pw.println("</center></body></html>");
	}
}//class