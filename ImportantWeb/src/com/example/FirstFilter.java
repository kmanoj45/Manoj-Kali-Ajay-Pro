package com.example;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

public class FirstFilter extends HttpFilter  {
    @Override   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		boolean valid=true;
		if(name.equals("")) {
			response.getWriter().println("<p>Name must be given</p>");
			valid=false;
		}
		if(age.equals("")) {
			response.getWriter().println("<p>Age must be given</p>");
			valid=false;
		}
		else if(Integer.parseInt(age)<18 || Integer.parseInt(age)>40) {
			response.getWriter().println("<p>Age is not valid</p>");
			valid=false;
		}
		if(valid) {
		// pass the request along the filter chain
			response.setContentType("text/html");			
			response.getWriter().println("<div style='background-color:red;color:white;font-family:Verdana'>");
			chain.doFilter(request, response);
			response.getWriter().println("</div>");
		}
		
	}


}
