package com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginPage")
public class loginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public loginPage() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		//Authentication
		if(username.equalsIgnoreCase("test") && password.equalsIgnoreCase("123"))
		   {
			//SessionID 
			String sid = username+"12345";
			//CSRF token
			double tokenid = (double) (Math.random() * 1000);
			String csrfToken = Double.toString(tokenid);
			
			//Storing SessionID and CSRF token in to a plain text
			 try {
				   FileWriter filewriter = new FileWriter("UserDetails.csv");
				   PrintWriter printwriter = new PrintWriter(filewriter);
				   printwriter.print("SID:"+sid+","+"CSRF:"+csrfToken);
				   printwriter.close();
				   
			 	 }catch(IOException e)
			 		{   System.out.print("Error");  }
			
			//Set SessionID to cookie in the browser
			   Cookie myCookie = new Cookie("myApp.sessionID",sid);
			   myCookie.setMaxAge(60*60*24*365);
			   response.addCookie(myCookie);
			
			//Display Session ID and CSRF token value in HomePage
			   request.getSession().setAttribute("myCookie", myCookie);
			   request.getSession().setAttribute("sessionID", sid);
			
			 response.addCookie(myCookie);
			 response.sendRedirect("HomePage.jsp");
		   }
		   else
		   {
			   response.sendRedirect("ErrorPage.jsp");
		   }
		   
		//doGet(request, response);
		
	}

}
