package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmpDao {
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void insertNewEmployee(Employee e){
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Employees (Employees_empID, Employees_deptNo, Employees_status, Employees_hasApp, Employees_username, Employees_password, Employees_email, Employees_empFirst, Employees_empLast)" +
					"VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getEmpID());
			ps.setInt(2, e.getDeptNum());
			ps.setDouble(3, e.getStatus());
			ps.setBoolean(4, e.isHasApp());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getFname());
			ps.setString(8, e.getLname());

			
			int affected = ps.executeUpdate();
			
			System.out.println(affected + " ROWS INSERTED");
		}catch(SQLException a){
			a.printStackTrace();
		}finally{
			close(ps);
		}
	}
	
	public Employee selectEmployeeByUsername(String username){
		Employee e = null;
		String sql = "SELECT * FROM Employees WHERE Applications_username = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setString(4, username);
			rs = ps.executeQuery();
			
			while(rs.next()){
				e = new Employee(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getBoolean(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getString(9)
						);
			}
			
		}catch(SQLException a){
			a.printStackTrace();
		}finally{
			close(ps);
		}
		
		return e;
	}
	
	public Employee selectEmployeeByIDNum(int empID){
		Employee e = null;
		String sql = "SELECT * FROM Employees WHERE Employees_empID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			rs = ps.executeQuery();
			
			while(rs.next()){
				e = new Employee(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getBoolean(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getString(9)
						);
			}
			
		}catch(SQLException a){
			a.printStackTrace();
		}finally{
			close(ps);
		}
		
		return e;
	}
	
	public List<Employee> returnAllEmps(){

		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee e = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Applications";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				e = new Employee();
				e.setUsername(rs.getString("EMPLOYEES_USERNAME"));
				// get employee object from userID
				employees.add(e);
			}
		} catch (SQLException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		return employees;
	}
	
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@sandbox171106.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl","jordan", "jordan1234");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from EMPLOYEES where username=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){
			System.out.println(e);
			}  
		return status;  
		}  
	}