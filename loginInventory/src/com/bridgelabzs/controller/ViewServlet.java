package com.bridgelabzs.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabzs.model.Country;
import com.bridgelabzs.repository.CountryService;
import com.bridgelabzs.repository.ICountryService;

 

@WebServlet("/view/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String spageid=request.getParameter("page");  
        HttpSession session = request.getSession();
        int noOfPages = (Integer)session.getAttribute("nOfPages");
        //request.getAttribute("currentPage");
        int recordsPerPages=(Integer)session.getAttribute("recordsPerPage");
        String rmspaces = spageid.replaceAll("\\s+", "");
        System.out.println(rmspaces);
        int pageid=Integer.parseInt(rmspaces);  
        int total=recordsPerPages;  
        if(pageid==1){}  
        else{  
            pageid=pageid-1;  
            pageid=pageid*total+1;  
        }  
        ICountryService country=new CountryService();
        List<Country> list=country.getRecords(pageid, total); 
  
        out.print("<h1>Page No: "+spageid+"</h1>");  
        out.print("<table border='1' cellpadding='4' width='60%'>");  
        out.print("<tr><th>Id</th><th>CountryName</th><th>Population</th>");  
        for(Country e:list){  
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPopulation()+"</td></tr>");  
        }  
        out.print("</table>");  
        
        for(int j=1;j<noOfPages;j++){
        out.print("<a href='ViewServlet?page=+"+j+"'>"+j+"</a> ");  
        }

        out.close();  
    }  
}  