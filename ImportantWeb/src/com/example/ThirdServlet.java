package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value= {"/Third","/Hello"},initParams= {@WebInitParam(name="dbname",value="aptechdb")})
public class ThirdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=getServletConfig().getInitParameter("DBUSER");
		String pwd=getServletConfig().getInitParameter("DBPWD");
		
		System.out.println("DB User = "+user);
		System.out.println("DB Password = "+pwd);
		
		String tuser=getServletContext().getInitParameter("DBUSER");
		System.out.println("Test User for Web App = "+tuser);
		
	}
}
