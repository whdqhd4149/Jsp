<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::list</title>
	</head>
	<body>
		<h3>MySQL User5 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user5/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				
				<td>${dto.name}</td>
				<td>${dto.gender}</td>
				<td>${dto.age}</td>
				<td>${dto.addr}</td>
				<td>
					<a href="/ch10/user5/modify.do?seq=${dto.seq}">수정</a>
					<a href="#">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>