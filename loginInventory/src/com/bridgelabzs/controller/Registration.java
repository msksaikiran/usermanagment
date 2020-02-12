package com.bridgelabzs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabzs.model.Dao;
@WebServlet("/view/register")
public class Registration extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
	
		try {
			int rs = register(name, password, gender, address);
			if (rs != 0) {
				out.print("<font color=#fdfdfd>");
				out.print("user Register sucessfully....");
				request.getRequestDispatcher("logins.html").include(request, response);
			} else {
				out.print("<font color=#fdfdfd>");
				out.print("user not Register ");
				request.getRequestDispatcher("register.html").include(request, response);
			}
		} catch (Exception ae) {

		}
	}

	public int register(String name, String password, String gender, String address) throws Exception {
		String query = "insert into login.inventory values(?,?,?,?)";
		System.out.println("**********");
		Connection conn = Dao.DbConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2, password);
		pst.setString(3, gender);
		pst.setString(4, address);
		int result = pst.executeUpdate();
		
		return result;
	}
}
