package com.revature.servlets;

import java.io.*;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
////import javax.servlet.http.*;  
////import com.oreilly.servlet.MultipartRequest;  
////  
public class UploadMedia extends HttpServlet {  
////  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();  
////          
////MultipartRequest m=new MultipartRequest(request,"d:/new");  
////out.print("successfully uploaded");  
	}  
}  