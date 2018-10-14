package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class FirstListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application Shut down..");		
	}
		
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("New Session Created..");
		ServletContext ctx=se.getSession().getServletContext();
		int cnt=0;
		if(ctx.getAttribute("counter")==null) {
			ctx.setAttribute("counter", 0);
			cnt= (int)ctx.getAttribute("counter") +1;
		}else {
			cnt= (int)ctx.getAttribute("counter") +1;	
			ctx.setAttribute("counter", cnt);
		}
		System.out.println("Total Sessions : "+cnt);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destroyed..");
		
		ServletContext ctx=se.getSession().getServletContext();
		
		int cnt=0;
		if(ctx.getAttribute("counter")==null) {
			ctx.setAttribute("counter", 0);
			cnt= (int)ctx.getAttribute("counter") -1;
		}else {
			cnt= (int)ctx.getAttribute("counter") -1;	
			ctx.setAttribute("counter", cnt);
		}
		System.out.println("Total Sessions : "+cnt);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application Started..");
	}
	
}
