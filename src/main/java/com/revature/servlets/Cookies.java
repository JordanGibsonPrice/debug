package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookie
 */
public class Cookies extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		//This creates a cookie, with the key = username, and value = password.
		
		try {
		Cookie cookie = new Cookie(request.getParameter("username"), request.getParameter("password"));
		
		cookie.setMaxAge(30); //Cookie deletes after 30 seconds
		
		response.addCookie(cookie);
		response.setContentType("text/html");
		String n = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("Cookie created!");
		out.print("Welcome "+n);
		
		out.print("<input type='submit' value='go'>");
		out.print("</form>");
		
		
		out.println(
				"<hr>" +
				"<a href='index.html'>BACK</a>"
				);
		out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}