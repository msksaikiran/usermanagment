package com.bridgelabz.userMangment.filter;

import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;
@WebFilter(value = "/*")
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig fg) throws ServletException {
	}

	HttpSession session = null;
	HttpServletRequest hreq = null;
	int serverToken = 0;
	int clientToken = 0;

	// type casting
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println("Method:Filter");
		/***** Set Response Content Type *****/
		response.setContentType("text/html");

		/***** Print The Response *****/

		PrintWriter out = response.getWriter();

		int timeout = 10;
		HttpSession sessionObj = request.getSession(true);

		/***** Setting The Updated Session Time Out *****/
		sessionObj.setMaxInactiveInterval(timeout);

		/*****
		 * Once The Time Out Is Reached. This Line Will Automatically Refresh The Page
		 *****/
		response.setHeader("Refresh", timeout + "; URL=timeout.jsp");
		request.getRequestDispatcher("link.html").include(request, response);

		chain.doFilter(req, res);

		out.close();
	}

	@Override
	public void destroy() {
	}
}