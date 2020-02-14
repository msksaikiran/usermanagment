package com.bridgelabz.userMangment.service;

import com.bridgelabz.userMangment.exception.UserException;
import com.bridgelabz.userMangment.model.User;
import com.bridgelabz.userMangment.repository.CountryService;
import com.bridgelabz.userMangment.repository.ICountryService;


public class UserServiceImplementation implements Service {
	ICountryService countryDao=new CountryService();
	@Override
	public String login(String name, String password) {
		
		return countryDao.userLogin(name,password);
		
	}
	
	@Override
	public int registerUser(String name, String password, String gender, String address){
		int result=0;
		
		User user=new User();
		try {
		user.setUname(name);
		user.setUpassword(password);
		
		result = countryDao.userRegister(name,password,gender,address);
		
		}catch(Exception ae) {
			throw new UserException("Invalid Details");
		}
		return result;
	}
	
	@Override
	public int registerCountry(String name, String population){
		int result=0;
		
		
		try {
		
		result = countryDao.CountryRegister(name,population);
		
		}catch(Exception ae) {
			throw new UserException("Invalid Details");
		}
		return result;
	}
	
	
}
