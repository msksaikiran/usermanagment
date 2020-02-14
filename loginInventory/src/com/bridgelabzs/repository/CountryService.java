package com.bridgelabzs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bridgelabzs.exception.UserException;
import com.bridgelabzs.model.Country;
import com.bridgelabzs.utils.Util;

public class CountryService implements ICountryService {

	public String userLogin(String name, String password) {

		String rsname = null;
		String query = "select * from login.inventory where username=? and password=?";
		Connection conn = Util.DbConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				rsname = result.getString(1);
			}
		} catch (Exception ae) {
			throw new UserException("Invalid Details");
		}
		return rsname;
	}

	public int userRegister(String name, String password, String gender, String address) {
		String query = "insert into login.inventory values(?,?,?,?)";

		Connection conn = Util.DbConnection();
		int result = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, gender);
			pst.setString(4, address);
			result = pst.executeUpdate();
			
		} catch (Exception ae) {
			throw new UserException("Invalid Details");
		}
		return result;
	}

	public List<Country> getRecords(int start, int noOfrecord) {
		List<Country> list = new ArrayList<Country>();
		try {
			Connection con = Util.DbConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from login.Countries limit " + (start - 1) + "," + noOfrecord);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Country e = new Country();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPopulation(rs.getInt(3));
				list.add(e);
			}

		} catch (Exception e) {
			throw new UserException("Invalid Details");
		}
		return list;
	}

	public int getNumberOfRows() {

		int numOfRows = 0;

		try {

			Connection con = Util.DbConnection();
			Statement stmt = con.createStatement();
			// Retrieving the data
			ResultSet rs = stmt.executeQuery("select count(*) from login.Countries");
			rs.next();
			// Moving the cursor to the last row
			numOfRows = rs.getInt("count(*)");
			System.out.println("Table contains " + numOfRows + " rows");

		} catch (SQLException ex) {
			Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
			throw new UserException("Invalid Details");
		}

		return numOfRows;
	}

	@Override
	public int CountryRegister(String name, String population) {
		
		String query = "INSERT INTO login.Countries(Name, Population) VALUES(?, ?)";
		Connection conn = Util.DbConnection();
		System.out.println("****");
		int result = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, population);
			result = pst.executeUpdate();
		} catch (Exception ae) {

			throw new UserException("Invalid Details");
		}
		return result;
	}
}