package cookieservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get")
public class GetCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public GetCookie() {}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			                                      throws ServletException, IOException 
	{
        PrintWriter pw = response.getWriter();
        
        pw.println("<html><body><center>");
        pw.println("<h1>Selected Books</h1>");
        Cookie []ck = request.getCookies();
        for(Cookie c:ck)
        {
        	pw.println(c.getValue()+"<br>");
        }
        pw.println("</center></body></html>");
	}//service
}//class