package com.bridgelabz.model;

public class User {
	private String uname, upass,ugender,uaddress;
    private int uphone;
    
	public String getUname() {
		//System.out.println(uname);
		return uname;

	}

	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("fdfd:" + uname);
	}

	public String getUpass() {
		return upass;

	}

	public void setUpass(String upass) {
		this.upass = upass;
		System.out.println("pass:" + upass);
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public int getUphone() {
		return uphone;
	}

	public void setUphone(int uphone) {
		this.uphone = uphone;
	}

	

}