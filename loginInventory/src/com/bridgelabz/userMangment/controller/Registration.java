package com.bridgelabz.userMangment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.userMangment.configuration.FactoryUser;
import com.bridgelabz.userMangment.service.UserServiceImplementation;



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
			UserServiceImplementation data = FactoryUser.getDetails();
			int rs = data.registerUser(name, password, gender, address);
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

	
}
