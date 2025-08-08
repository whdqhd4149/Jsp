<<<<<<< HEAD
<%@page import="vo.User6VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "whdqhd4149";
	String pass = "1234";
	
	List<User6VO> users = new ArrayList<>();

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM USER6";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println(rs);
		
		while(rs.next()){
			
			User6VO vo = new User6VO();
			vo.setName(rs.getString(1));
			vo.setGender(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setAddr(rs.getString(4));
			
			users.add(vo);
			
		}
		
		System.out.println(users);
		
		rs.close();
		stmt.close();
		conn.close();
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user6::list</title>
	</head>
	<body>
		<h3>User6 목록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>			
			</tr>
			<% for(User6VO user6VOasd : users){ %>
			<tr>
				<td><%= user6VO.getName() %></td>
				<td><%= user6VO.getGender() %></td>
				<td><%= user6VO.getAge() %></td>
				<td><%= user6VO.getAddr() %></td>
				<td>
					<a href="./modify.jsp?name=<%= user6VO.getName() %>">수정</a>
					 
					<a href="./delete.jsp?name=<%= user6VO.getName() %>">삭제</a>
				
				</td>						
			</tr>
			<% } %>
		</table>
	</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
>>>>>>> 79ece32404434d2674d069cc7aa4443c52e6117e
