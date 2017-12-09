package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;
import static com.revature.util.CloseStreams.close;

public class AccountDao {
		
	private List<Account> accounts = new ArrayList<Account>();
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void insertNewAccount(Account i){
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Accounts (Accounts_accNum, Accounts_username, Accounts_atHand, Accounts_applied, Accounts_pending)" +
					"VALUES(?,?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, i.getAccNum());
			ps.setString(2, i.getUsername());
			ps.setInt(3, i.getAtHand());
			ps.setInt(4, i.getApplied());
			ps.setInt(5, i.getPending());

			int affected = ps.executeUpdate();
			
			System.out.println(affected + " ROWS INSERTED");
		}catch(SQLException o){
			o.printStackTrace();
		}finally{
			close(ps);
		}
	}
	
	public Account selectAccountByAccNum(Integer accNum){ 
		 Account a = null;
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
			ps.setInt(1, accNum);
			rs = ps.executeQuery();
			
			while(rs.next()){
				a = new Account(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4),
							rs.getInt(5)
						);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
		return a;
	}
	
	//Need a function for returning accounts on a left/right join for usernames
	
	public List<Account> accountsAndApps(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT Jordan.APPLICATIONS.MOMENT, Jordan.APPLICATIONS.EMPFIRST, Jordan.APPLICATIONS.EMPLAST, Jordan.APPLICATIONS.DESCRIPTION, Jordan.APPLICAITONS.EXPENSE, Jordan.APPLICATIONS.GRADING, Jordan.APPLICATIONS.EVENTTYPE FROM Jordan.APPLICATIONS RIGHT OUTER JOIN Jordan.ACCOUNTS ON APPLICATIONS,APPID = ACCOUNTS.APPID";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				acc = new Account();
				accounts.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	
	public List<Account> returnAllAccounts(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Accounts";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				acc = new Account();
				acc.setAccNum(rs.getInt("ACCOUNTS_ACCNUM"));
				// get account object from account number
				accounts.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts; 
	}
}


	//maybe make this class the driver??? 
