package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formController
 */
@WebServlet("/formController")
public class formController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public formController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		//PrintWriter out = response.getWriter();
		String csrfValue = request.getParameter("csrfVal");
		
		 String cookieVal = null;
		 Cookie[] Cookies = request.getCookies();
		 if(Cookies != null)
		 {
		  for(Cookie tempCookie:Cookies)
		  {
			if("myApp.tokenID".equals(tempCookie.getName()))
			{
				cookieVal = tempCookie.getValue();
				break;
			}
		  }
	     }
		
		 System.out.println(csrfValue);
		 System.out.println(cookieVal);
		
		if(csrfValue.equalsIgnoreCase(cookieVal))
		{
			response.sendRedirect("SuccessMSG.jsp");
			
		}
		else {
			   response.sendRedirect("ErrorPage.jsp");
		     }
		
		
		  
		   
		//doGet(request, response);
	}

}
