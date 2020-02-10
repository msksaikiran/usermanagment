package com.bridgelabzs.inventor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabzs.Utility.Util;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try {
			String rsname = login(name, password);

			if (rsname != null) {
				out.print("<font color=#fdfdfd>");
				out.print("You are successfully logged in!");
				out.print("<br>Welcome, " + rsname);
				// cookie object..
				Cookie ck = new Cookie("name", name);
				response.addCookie(ck);
				// context object...
				ServletContext context = request.getServletContext();
				context.setAttribute("name", rsname);
				// session object..
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10);
				request.getRequestDispatcher("inventory.html").include(request, response);
			} else {
				out.print("<font color=#fdfdfd>");
				out.print("sorry, username or password Incorrect!");
				request.getRequestDispatcher("index.html").include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.close();
	}

	public String login(String name, String password) throws Exception {
		String rsname = null;
		String query = "select * from login.inventory where username=? and password=?";
		Connection conn = Util.DbConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2, password);
		ResultSet result = pst.executeQuery();
		while (result.next()) {
			rsname = result.getString(1);
		}
		return rsname;
	}

}