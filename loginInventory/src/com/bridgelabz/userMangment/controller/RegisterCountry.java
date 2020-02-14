package com.bridgelabz.userMangment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.userMangment.configuration.FactoryUser;
import com.bridgelabz.userMangment.service.UserServiceImplementation;

@WebServlet("/view/country")
public class RegisterCountry extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String population = request.getParameter("population");
		
		try {
			UserServiceImplementation data = FactoryUser.getDetails();
			int rs = data.registerCountry(name,population);
			System.out.println("sucess...");
			if (rs != 0) {
				//out.print("<font color=#fdfdfd>");
				out.print("Country Details Save sucessfully....");
				request.getRequestDispatcher("inventory.html").include(request, response);
			} else {
				out.print("<font color=#fdfdfd>");
				out.print("user not Register ");
				request.getRequestDispatcher("countryDetails.html").include(request, response);
			}
		} catch (Exception ae) {

		}
	}
}
