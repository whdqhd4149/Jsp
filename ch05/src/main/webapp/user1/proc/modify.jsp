<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String age = request.getParameter("age");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "whdqhd4149";
	String pass = "1234";

	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		Statement stmt = conn.createStatement();
		
		String sql = "UPDATE USER1 SET name='" + name+ "', hp='" + hp + "', age=" + age + " ";
				sql += "WHERE user_id='" +user_id+ "'";		
		
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");
%>