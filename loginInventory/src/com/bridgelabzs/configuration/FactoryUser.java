package com.bridgelabzs.configuration;

import com.bridgelabzs.service.UserServiceImplementation;

public class FactoryUser {

	public  static UserServiceImplementation getDetails() {
		UserServiceImplementation impl=new UserServiceImplementation();
		return impl;
	}
}
