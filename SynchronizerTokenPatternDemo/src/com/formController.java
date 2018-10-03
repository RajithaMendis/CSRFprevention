package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		String cookieSid = request.getParameter("sessionKey");
		System.out.println(csrfValue);
		System.out.println(cookieSid);
		
		   FileReader filereader = new FileReader("UserDetails.csv");
		   BufferedReader bufferreader = new BufferedReader(filereader);
		   String str;
		   String CSRF = null;
		   while((str = bufferreader.readLine()) != null)
		   {
			   String[] memo = str.split(",");
			   String[] sidVal = memo[0].split(":");
			   String[] csrfVal = memo[1].split(":");
			   if(cookieSid.equalsIgnoreCase(sidVal[1]))
			   {
				   CSRF = csrfVal[1];
				   if(csrfValue.equalsIgnoreCase(CSRF))
				   {
					   response.sendRedirect("SuccessPage.jsp");
					  // request.getSession().setAttribute("result", "Success Message");
					   //out.print("True");
				   }
				   else {
					   response.sendRedirect("ErrorPage.jsp");
					   //request.getSession().setAttribute("result", "Error Message");
					   //out.print("False");
				   }
			   }
		   }
		
		  
		   
		//doGet(request, response);
	}

}
