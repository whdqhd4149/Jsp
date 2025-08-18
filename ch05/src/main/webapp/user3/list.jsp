<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="vo.User3VO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "whdqhd4149";
	String pass = "1234";
		
	List<User3VO> users = new ArrayList<>();
		
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM USER3";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			User3VO vo = new User3VO();
			vo.setUser_id(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setHp(rs.getString(3));
			vo.setAge(rs.getInt(4));
			
			users.add(vo);
						
		}
		
		conn.close();
		stmt.close();
		rs.close();
					
	}catch(Exception e){
		e.printStackTrace();		
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::list</title>
	</head>
	<body>
		<h3>User3 목록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>			
			</tr>
			<% for(User3VO user3VO : users){ %>
			<tr>
				<td><%= user3VO.getUser_id() %></td>
				<td><%= user3VO.getName() %></td>
				<td><%= user3VO.getHp() %></td>
				<td><%= user3VO.getAge() %></td>
				<td>
				
				<a href="./modify.jsp?user_id=<%= user3VO.getUser_id()%>">수정</a>
				<a href="./delete.jsp?user_id=<%= user3VO.getUser_id()%>">삭제</a>
				
				</td>					
			</tr>
			<% } %>		
		</table>
		
		
	</body>
</html>