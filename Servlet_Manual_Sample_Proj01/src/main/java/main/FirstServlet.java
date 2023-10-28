package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebServlet("/first")
public class FirstServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("uName");
		String s2 = request.getParameter("mail");
		PrintWriter pw = response.getWriter();
		pw.println("UserName :: " + s1);
		pw.println("Mail :: " + s2);
	}
}//class