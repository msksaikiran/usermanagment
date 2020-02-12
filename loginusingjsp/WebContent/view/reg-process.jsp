<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*,java.util.*"%>
 <%@page import="com.bridgelabz.contoller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String fname=request.getParameter("name");
String password=request.getParameter("password");
String number=request.getParameter("number");
String gender=request.getParameter("gender");
String address=request.getParameter("address");

int status=RegisterDao.register(fname,password,number,gender,address);
if(status!=0){
	out.print("user register sucessfully....");
}
%> 
</body>
</html>