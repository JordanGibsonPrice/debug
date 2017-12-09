package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBInput {

	public static void main(String[] args) {
		
		Connection conn = null;
		String sql = "";
		PreparedStatement stmt = null;
		InputStream is = null;
	
		File tempFile = new File("ws.pdf");
		System.out.println(tempFile.exists()?"This file exists":"The sample file does not exist! Did you delete \"ws.pdf\"?");
		
		try {
			is = new FileInputStream(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setBinaryStream(1, is, tempFile.length());
			System.out.println("Executing SQL Statement: " + sql);
			System.out.println("Connection is valid: " + conn.isValid(5));
			System.out.println("Rows updated: " + stmt.executeUpdate());
			System.out.println("Success!");
		} catch (SQLException e) {
			System.out.println("Failure!");
			e.printStackTrace();
		}
		
		
		
		
	}

}