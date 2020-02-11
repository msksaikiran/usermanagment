package com.bridgelabzs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view/profile")
public class ProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		Cookie ck[] = request.getCookies();
		if (ck != null) {
			String name = ck[0].getValue();
			Object conname = request.getServletContext().getAttribute(name);
			ServletConfig config=getServletConfig();  
			
			if (!name.equals("") || name != null) {
				out.print("<b>Welcome to Profile</b>");
				out.print("<br>Welcome, " + name);
			}
		} else {
			out.print("<font color=#fdfdfd>");
			out.print("<h1>PLEASE LOGIN FISRT</h1>");
			out.print("</div>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}