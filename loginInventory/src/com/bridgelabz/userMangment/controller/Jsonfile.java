package com.bridgelabz.userMangment.controller;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/view/json")
public class Jsonfile extends HttpServlet{

	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter out = res.getWriter();
		String choice=req.getParameter("product");
		String name = req.getParameter("item");
		
		String weight = req.getParameter("weight");
	
		String price = req.getParameter("price");
		double wt = Double.parseDouble(weight);
		double pr = Double.parseDouble(price);
		createJsonFile(choice,name,wt,pr);
		//req.getSession().setMaxInactiveInterval(10);
		req.getRequestDispatcher("inventory.html").include(req,res);
		
	}
	@SuppressWarnings("unchecked")
	public JSONObject createJsonFile(String choice,String name,double wt,double pr) {
		JSONObject obj=new JSONObject();
		 JSONArray arr1 = new JSONArray();
		try {
				JSONObject json= new JSONObject();
			    obj=new JSONObject();
				json.put("Name",name);
				System.out.println("name"+name);
				json.put("weight", wt);
				System.out.println(wt);
				json.put("price",pr);
				arr1.add(json);
				obj.put(choice, arr1);
				 //arr.add(json);
				 writeIntoFile(arr1);
		} catch (Exception e) {
			System.out.println("Not Proper value");
		}
		return obj;
	}
	
		
	public static void writeIntoFile(JSONArray array)  {
		// TODO Auto-generated method stub
		
		try {
			FileWriter write=new FileWriter("/home/user/Desktop/stock23.json");
			write.write(array.toJSONString());
			write.flush();
			write.close();
			System.out.println("file successfully copied...");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	}

}
