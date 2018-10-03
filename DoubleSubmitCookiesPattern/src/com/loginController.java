package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public loginController() {
       
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
			
			//Set SessionID and CSRF token to cookies in the browser
			   Cookie sessionCookie = new Cookie("myApp.sessionID",sid);
			   sessionCookie.setMaxAge(60*60*24*365);
			   response.addCookie(sessionCookie);
			   
			   Cookie tokenCookie = new Cookie("myApp.tokenID",csrfToken);
			   tokenCookie.setMaxAge(60*60*24*365);
			   response.addCookie(tokenCookie);
			
			//Display Session ID and CSRF token value in HomePage
			   request.getSession().setAttribute("sessionID", sid);
			   request.getSession().setAttribute("csrfToken", csrfToken);
			
			 response.addCookie(sessionCookie);
		     response.addCookie(tokenCookie);
			 response.sendRedirect("HomePage.jsp");
		   }
		   else
		   {
			   response.sendRedirect("ErrorPage.jsp");
		   }
		
		
		//doGet(request, response);
	}

}
