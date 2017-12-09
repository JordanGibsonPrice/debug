package com.revature.beans;

public class Account {
	private int accNum;
	private String username;
	private int atHand;
	private int applied;
	private int pending;
	
	public Account(int accNum, String username, int grade, int applied, int pending){
		super();
		this.accNum = accNum;
		this.username = username;
		this.atHand = 1000-this.pending-this.applied;
		this.applied = applied;
		this.pending = pending;
	}
	public Account(int accNum, String username) {
		this.accNum = accNum;
		this.username = username;
	}

	public Account() {
		super();
	}


	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAtHand() {
		return atHand;
	}

	public void setAtHand(int atHand) {
		this.atHand = atHand;
	}

	public int getApplied() {
		return applied;
	}

	public void setApplied(int applied) {
		this.applied = applied;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", username=" + username + ", atHand=" + atHand
				+ ", applied=" + applied + ", pending=" + pending + "]";
	}
	

}
//accNum number(3),
//username varchar(30),
//grade number(1),
//atHand number(4),
//applied number(4),
//pending number(4),