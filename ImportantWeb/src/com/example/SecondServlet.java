package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/Second",loadOnStartup=1)
public class SecondServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("Second Servlet initialized..");
	}
	
	@Override
	public void destroy() {
		System.out.println("Second Servlet destroyed..");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Second Servlet giving service");
		System.out.println("Global User "+getServletContext().getInitParameter("DBUSER"));
	}
}
