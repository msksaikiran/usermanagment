package com.bridgelabz.userMangment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.userMangment.exception.UserException;

import com.bridgelabz.userMangment.service.Service;
import com.bridgelabz.userMangment.service.UserServiceImplementation;

@WebServlet("/view/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try {
			Service service = new UserServiceImplementation();
			String rsname = service.login(name, password);

			if (rsname != null) {
				out.print("<font color=black>");
				out.print("You are successfully logged in!");
				out.print("<br>Welcome, " + rsname);

				/*
				 * cookie object..
				 */
				Cookie ck = new Cookie("name", name);
				response.addCookie(ck);

				/*
				 * setting the username into session obj based on this we are destorying the
				 * cokkie
				 */
				ServletContext context = getServletContext();
				context.setAttribute("username", name);

				request.getRequestDispatcher("inventory.html").include(request, response);
			} else {
				out.print("<font color=#fdfdfd>");
				out.print("sorry, username or password Incorrect!");
				request.getRequestDispatcher("index.html").include(request, response);
			}

		} catch (Exception e) {
			throw new UserException("Invalid Details...");
		}

		out.close();
	}

}