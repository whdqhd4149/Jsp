<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User4::modify</title>
	</head>
	<body>
		<h3>MySQL User4 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user4/list.do">목록이동</a>
		
		<form action="/ch10/user4/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" readonly value="${User4DTO.uid}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${User4DTO.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="${User4DTO.gender}" placeholder="성별 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${User4DTO.age}" placeholder="나이 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${User4DTO.hp}" placeholder="휴대폰 입력(-포함)"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${User4DTO.addr}" placeholder="주소 입력"/></td>
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