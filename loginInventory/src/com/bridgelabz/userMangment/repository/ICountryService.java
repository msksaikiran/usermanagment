package com.bridgelabz.userMangment.repository;

import java.util.List;

import com.bridgelabz.userMangment.model.Country;


public interface ICountryService  {
    
	public String userLogin(String name, String password);
	public int userRegister(String name, String password, String gender, String address);
	public List<Country> getRecords(int start,int noOfrecord);
    public int getNumberOfRows();
	public int CountryRegister(String name, String population);
}