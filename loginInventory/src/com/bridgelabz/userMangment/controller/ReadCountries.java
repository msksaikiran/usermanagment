package com.bridgelabz.userMangment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.userMangment.model.Country;
import com.bridgelabz.userMangment.repository.CountryService;


@WebServlet(name = "ReadCountries", urlPatterns = {"/view/ReadCountries"})
public class ReadCountries extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        //System.out.println(request.getParameter("currentPage")+"pages...");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        //System.out.println(currentPage);
        CountryService countryService = new CountryService();
        
        List<Country> countries = countryService.getRecords(currentPage, recordsPerPage);
                
        request.setAttribute("countries", countries);
        
        int rows = countryService.getNumberOfRows();
        System.out.println(rows+"::rows");
        int nOfPages = rows / recordsPerPage;
        
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        System.out.println(nOfPages);
        HttpSession session = request.getSession();
        session.setAttribute("nOfPages", nOfPages);
        session.setAttribute("currentPage", currentPage);
        session.setAttribute("recordsPerPage", recordsPerPage);

        response.sendRedirect("viewdata.html");
        
       
    }
}