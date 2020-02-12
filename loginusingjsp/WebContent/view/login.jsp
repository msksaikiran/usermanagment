<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.bridgelabz.contoller.*,com.bridgelabz.model.*"%>
<%@page import="com.bridgelabz.repository.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.bridgelabz.model.User"/>  
  
<jsp:setProperty property="uname" param="name" name="obj"/>  
<jsp:setProperty property="upass" param="password" name="obj"/>  
  
<%  
User user=new User();
String status=login.register(obj); 

if(status!=null)  {
out.print("You are login succesfully..."); 
out.println("Welcome " +status);
}
else{
out.println("Invalid password or username.");
}
  
%>  
	

</body>
</html>