package com.bridgelabz.userMangment.configuration;

import com.bridgelabz.userMangment.service.UserServiceImplementation;

public class FactoryUser {

	public  static UserServiceImplementation getDetails() {
		UserServiceImplementation impl=new UserServiceImplementation();
		return impl;
	}
}
