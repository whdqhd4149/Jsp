<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop/Product::list</title>
	</head>
	<body>
		<h3>Shop/Product 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/product/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>재고량</th>
				<th>가격</th>
				<th>제조회사</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${dtoList}">			
			<tr>
				<td>${dto.pno}</td>
				<td>${dto.pname}</td>
				<td>${dto.stock}</td>
				<td>${dto.price}</td>
				<td>${dto.company}</td>
				<td>			
					<a href="/ch10/shop/product/modify.do?pname=${dto.pname}">수정</a>		
					<a href="">삭제</a>
				</td>				
			</tr>
			</c:forEach>				
		</table>				
	</body>
</html>