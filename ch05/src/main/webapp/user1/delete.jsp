<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String user_id = request.getParameter("user_id");

	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "whdqhd4149";
	String pass = "1234";
	
	try{		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		PreparedStatement psmt = conn.prepareStatement("DELETE FROM USER1 WHERE USER_ID = ?");
		psmt.setString(1, user_id);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
			
	}catch(Exception e){
		e.printStackTrace();
	}

%>