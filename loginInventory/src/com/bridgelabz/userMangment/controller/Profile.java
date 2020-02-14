package com.bridgelabz.userMangment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.userMangment.model.User;

@WebServlet("/view/profile")
public class Profile extends HttpServlet {
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie ck[] = request.getCookies();

		String name = ck[0].getValue();
		ServletContext context = request.getServletContext();
		String username = (String) context.getAttribute("username");
		System.out.println("username:" + username);
		System.out.println("ckname:" + name);
		if (name.equals(username)) {
			out.print("<b>Welcome to Profile</b>");
			out.print("<br>Welcome, " + name);
		} else {
			//out.print("<font color=#fdfdfd>");
			out.print("<h1>PLEASE LOGIN FISRT</h1>");
			out.print("</div>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}