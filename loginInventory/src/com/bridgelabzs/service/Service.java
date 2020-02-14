package com.bridgelabzs.service;

public interface Service {

	String login(String name,String password);
	public int registerUser(String name, String password, String gender, String address);
	public int registerCountry(String name, String population);
	
}
