package com.bridgelabzs.controller;

import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabzs.utils.Util;


@WebServlet("/view/products")
public class Products extends HttpServlet{

	public void post(HttpServletRequest req,HttpServletResponse res) {
		inventoryProducts();
	}

@SuppressWarnings("unchecked")
public void inventoryProducts() {
	
	JSONArray obj;
	try {
		obj = Util.readFile();
		obj.forEach((data) -> {
			JSONObject data2 = (JSONObject) data;
			Set keys = data2.keySet();
			System.out.print(String.join("", keys) + "\t");

		});
		System.out.println();
	} catch (Exception e) {
		System.out.println("Not aProper File");
	}

}
}