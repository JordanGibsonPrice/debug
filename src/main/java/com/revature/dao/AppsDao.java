package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Application;
import com.revature.util.ConnectionUtil;

public class AppsDao {
	private List<Application> applications = new ArrayList<Application>();
	
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	public void insertNewApplication(Application a){
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Applications (Applications_empID, Applications_appID, Applications_empFirst, Applications_empLast, Applications_moment, Applications_locus, Applications_description, Applications_grading, Applications_eventType, Applications_justification)" +
					"VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getAccNum());
			ps.setInt(2, a.getAppID());
			ps.setDouble(3, a.getExpense());
			ps.setInt(4, a.getEventType());
			ps.setString(5, a.getDescription());
			ps.setString(6, a.getJustification());
			ps.setString(7, a.getEmpFirst());
			ps.setString(8, a.getEmpLast());
			ps.setString(9, a.getLocus());
			ps.setString(10, a.getEmail());
			
			
			int affected = ps.executeUpdate();
			
			System.out.println(affected + " ROWS INSERTED");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
	}
	
	public Application selectApplicationByAppID(Integer appID){
		Application a = null;
		String sql = "SELECT * FROM Applications WHERE Applications_appID = ?";
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
			ps.setInt(1, appID);
			rs = ps.executeQuery();
			
			while(rs.next()){
				a = new Application(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7),
							rs.getBlob(8)
						);
			}
//			this.empID = empID;
//			this.accNum = accNum;
//			this.deptNum = deptNum;
//			this.email = email;
//			this.empFirst = empFirst;
//			this.empLast = empLast;
//			this.eventType = eventType;
//			this.blobbert = blobbert;
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
		return a;
	}
	
	public List<Application> returnAllApps(){ 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Application app = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Applications";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				app = new Application();
				app.setAppid(rs.getInt("APPLICATIONS_APPID"));
				// get employee object from userID
				applications.add(app);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applications;
	}
}