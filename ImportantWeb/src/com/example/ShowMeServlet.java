package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowMe")
public class ShowMeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		
		resp.getWriter().println("Name "+name);
		resp.getWriter().println("Age "+age+" years");
		int count=(int)getServletContext().getAttribute("counter");				
		resp.getWriter().println("You are user number "+count);
		
		HttpSession session=req.getSession();		
		session.invalidate(); //destroy the session
		
	}
}
