<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="vo.User6VO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "whdqhd4149";
	String pass = "1234";
	
	User6VO user6 = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "SELECT SEQ, NAME, GENDER, AGE, ADDR FROM USER6 WHERE SEQ=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, "seq");
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user6 = new User6VO();
			user6.setName(rs.getString(1));
			user6.setGender(rs.getString(2));
			user6.setAge(rs.getInt(3));
			user6.setAddr(rs.getString(4));
			user6.setSeq(rs.getInt(5));
		
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
		<title>user6::modify</title>
	</head>
	<body>
		<h3>User6 수정</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<input type="hidden" name="seq" value="<%= user6.getSeq()%>"/>
			<table border="1">
			
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%= user6.getName() %>" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="<%= user6.getGender() %>" placeholder="성별 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="<%= user6.getAge() %>" placeholder="숫자 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="<%= user6.getAddr() %>" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>			
			</table>
		</form>
	</body>
