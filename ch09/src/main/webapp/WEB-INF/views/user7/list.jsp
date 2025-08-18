<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user7::list</title>
	</head>
	<body>
		<h3>User7 목록</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/user7/register.do">등록하기</a>
		
		<table border ="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>이메일</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${requestScope.dtoList}">
			<tr>
				<td>${dto.getId()}</td>
				<td>${dto.getName()}</td>
				<td>${dto.age}</td>
				<td>${dto.email}</td>
				<td>
					<a href="/ch09/user7/modify.do?id=${dto.id}">수정</a>
					<a href="/ch09/user7/delete.do?id=${dto.id}">삭제</a>				
				</td>
			</tr>
			</c:forEach>
		</table>		
	</body>
</html>