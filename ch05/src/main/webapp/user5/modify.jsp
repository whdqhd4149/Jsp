<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="vo.User5VO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	String name = request.getParameter("name");

	String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "whdqhd4149";
	String pass = "1234";
	
	User5VO user5 = null;
	
	try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(host, user, pass);
			
			String sql = "SELECT * FROM USER5 WHERE NAME=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				user5 = new User5VO();
				user5.setName(rs.getString(1));
				user5.setGender(rs.getString(2));
				user5.setAge(rs.getInt(3));
				user5.setAddr(rs.getString(4));				
			}
			
			rs.close();
			psmt.close();
			conn.close();
					
	}catch(Exception e){
		e.printStackTrace();		
	}
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>user5::modify</title>
		</head>
	<body>
		<h3>User5 수정</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./modify.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" readonly value="<%= user5.getName() %>" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="<%= user5.getGender() %>" placeholder="성별 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%= user5.getAge() %>" placeholder="숫자 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="<%= user5.getAddr() %>" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>				
				</tr>			
			</table>	
		</form>	
	</body>
</html>