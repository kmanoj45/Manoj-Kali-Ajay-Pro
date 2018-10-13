package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class FirstServlet extends HttpServlet {
	
	public FirstServlet() {
		System.out.println("Servlet object created..");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initialized..");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet destroyed..");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Servlet giving service");
	}
}
