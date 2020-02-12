package com.bridgelabz.contoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.model.User;

public class login {
	public static String register(User u) {
		ResultSet status = null;
		String rsname = null;
		String query = "select * from login.inventory where username=? and password=?";
		try {
			Connection con = com.bridgelabz.repository.Dao.DbConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u.getUname());
			System.out.println("getuser:" + u.getUname());
			ps.setString(2, u.getUpass());
			System.out.println("getuser:" + u.getUpass());
			status = ps.executeQuery();
			while (status.next()) {
				System.out.println("user login...");

				rsname = status.getString(1);

			}

		} catch (Exception e) {
		}

		return rsname;
	}
}
