package com.revature.beans;

import java.sql.Blob;


//import org.joda.time.DateTime;

public class Application {
	private int empID;
	private int deptNum;
	private int accNum;
	private int appID;
	private int standing;
	private int grade;
	private String empFirst;
	private String empLast;
	private String email;
//	private DateTime moment;
	private String locus;
	private String description;
	private double expense;
	private int eventType;
	private String justification;
	private Blob blobbert;
// 	<label><b>Employee ID</b></label>
//  	<input type="number" placeholder="Employee Id" name="registration" formenctype="multipart/form-data" required>
//  	<label><b>Department Number</b></label>
//  	<input type="number" placeholder="Department number" name="registration" min="1" max="5" formenctype="multipart/form-data" required>
//  	Select image(s) to help your case: <input type="file" name="registration" multiple accept="file_extension|audio/*|video/*|image/*|media_type" action="Upload()">
//    <label><b>User Name</b></label>
//    <input type="text" placeholder="User Name" name="registration" pattern=".{6,}" title="Six or more characters" formenctype="multipart/form-data" required>
//    <label><b>Password</b></label>
//    <input type="password" placeholder="Enter Password" name="pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
//    <label><b>Email</b></label>
//    <input type="email" placeholder="Enter Email" name="registration" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" formenctype="multipart/form-data" required>
//    <label><b>First Name</b></label>
//    <input type="text" placeholder="First Name" name="registration" formenctype="multipart/form-data" required>
//    <label><b>Last Name</b></label>
//    <input type="text" placeholder="Last Name" name="registration" formenctype="multipart/form-data" required>
//    <input list="reimburseType">
//		<datalist id="reimburseType">
//  			<option value="University Courses">
//  			<option value="Seminars">
//  			<option value="Certifcation Prep Class">
//  			<option value="Certification">
//  			<option value="Technical Training">
//  			<option value="Other">
//		</datalist>
	public Application(int empID, int accNum, int deptNum, String email, String empFirst, String empLast, int eventType, Blob blobbert) {
		super();
		this.empID = empID;
		this.accNum = accNum;
		this.deptNum = deptNum;
		this.email = email;
		this.empFirst = empFirst;
		this.empLast = empLast;
		this.eventType = eventType;
		this.blobbert = blobbert;
	}




	public Application(int empID, int deptNum, int accNum, int appID, int standing, int grade, String empFirst,
		String empLast, String email, String locus, String description, double expense, int eventType,
		String justification, Blob blobbert) {
	super();
	this.empID = empID;
	this.deptNum = deptNum;
	this.accNum = accNum;
	this.appID = appID;
	this.standing = standing;
	this.grade = grade;
	this.empFirst = empFirst;
	this.empLast = empLast;
	this.email = email;
	//this.moment = new org.joda.time.DateTime();
	this.locus = locus;
	this.description = description;
	this.expense = expense;
	this.eventType = eventType;
	this.justification = justification;
	this.blobbert = blobbert;
}




	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getaccNum() {
		return accNum;
	}

	public void setaccNum(int accNum) {
		this.accNum = accNum;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppid(Integer appID) {
		this.appID = appID;
	}

	public String getEmpFirst() {
		return empFirst;
	}

	public void setEmpFirst(String empFirst) {
		this.empFirst = empFirst;
	}

	public String getEmpLast() {
		return empLast;
	}

	public void setEmpLast(String empLast) {
		this.empLast = empLast;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public DateTime getMoment() {
//		return moment;
//	}

	public String getLocus() {
		return locus;
	}

	public void setLocus(String locus) {
		this.locus = locus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}
	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public int getStanding() {
		return standing;
	}

	public void setStanding(int standing) {
		this.standing = standing;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	
	public Blob getBlobbert() {
		return blobbert;
	}

	public void setBlobbert(Blob blobbert) {
		this.blobbert = blobbert;
	}




	@Override
	public String toString() {
		return "Application [accNum=" + accNum + ", appID=" + appID + ", standing=" + standing + ", grade=" + grade
				+ ", empFirst=" + empFirst + ", empLast=" + empLast + ", email=" + email 
				+ ", locus=" + locus + ", description=" + description + ", expense=" + expense + ", eventType="
				+ eventType + ", justification=" + justification + "]";
	}

	

}