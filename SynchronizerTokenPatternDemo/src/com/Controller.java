package com;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/plain");
		String sessionID = request.getParameter("sessionID");
		//System.out.println(sessionID);
		
		FileReader filereader = new FileReader("UserDetails.csv");
		   BufferedReader bufferreader = new BufferedReader(filereader);
		   String str;
		   String CSRF = null;
		   while((str = bufferreader.readLine()) != null)
		   {
			   String[] memo = str.split(",");
			  // System.out.println(memo[0]+":::"+memo[1]);
			   String[] sidVal = memo[0].split(":");
			   String[] csrfVal = memo[1].split(":");
			   if(sessionID.equalsIgnoreCase(sidVal[1]))
			   {
				   CSRF = csrfVal[1];
			   }
		   }
		
		  // System.out.println(CSRF);
		   PrintWriter out = response.getWriter();
		   out.print(CSRF);
	}

}
