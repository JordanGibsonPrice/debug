package com.revature.servlets;
import com.revature.beans.Application;
import com.revature.beans.Employee;
import com.revature.dao.AppsDao;
import com.revature.dao.EmpDao;
import com.revature.services.Updating;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		if(Updating.update(request, null, null, 0)){
//			out.write("<h1>USER UPDATED</h1>");
//		}else{
//			out.write("<h1>UPDATE FAILED</h1>");
//		}

	}
	

	
	
	

}