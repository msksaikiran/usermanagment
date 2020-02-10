package com.bridgelabzs.inventor;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import com.bridgelabzs.Utility.Util;

@WebServlet("/display")
public class DiplayJsonFile extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		//out.print("Inventory Products..");
		String choice = req.getParameter("item");
		req.getRequestDispatcher("link.html").include(req, res);
		try {
			JSONArray obj = Util.readFile();
			obj.forEach((data) -> {
				//System.out.println(data);
				
				JSONObject data2 = (JSONObject) data;
				JSONArray list = (JSONArray) data2.get(choice);
				if (list != null) {
					list.forEach((ls) -> {
						// for (Object ls : list) 
						JSONObject obj1 = (JSONObject) ls;
						out.println("ComapnyName:" + obj1.get("Name"));
						out.println("\n");
						out.println("NumberOfShares:" + obj1.get("weight"));
						out.println("\n");
						out.println("Shareprice:" + obj1.get("price"));
						out.println("\n");
					});
				}

			});
	
		} catch (Exception e) {
			System.out.println("error>>>>>");
		}
		//displayItems(choice);
	}
	
	@SuppressWarnings("unchecked")
	public void displayItems(String choice) {
		try {
			JSONArray obj = Util.readFile();
			obj.forEach((data) -> {
				//System.out.println(data);
				
				JSONObject data2 = (JSONObject) data;
				JSONArray list = (JSONArray) data2.get(choice);
				if (list != null) {
					list.forEach((ls) -> {
						// for (Object ls : list) 
						JSONObject obj1 = (JSONObject) ls;
						System.out.println("ComapnyName:" + obj1.get("Name"));
						System.out.println("NumberOfShares:" + obj1.get("weight"));
						System.out.println("Shareprice:" + obj1.get("Price"));
						System.out.println();
					});
				}

			});
	
		} catch (Exception e) {
			System.out.println("error>>>>>");
		}
	//return data;
	}
	
}