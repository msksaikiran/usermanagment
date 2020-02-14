package com.bridgelabz.userMangment.model;

public class User {

	private String uname;
	private String upassword;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("username::"+uname);
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", upassword=" + upassword + "]";
	}
	
	
}
