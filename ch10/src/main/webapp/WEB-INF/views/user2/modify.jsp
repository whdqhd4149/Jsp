<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User2::modify</title>
	</head>
	<body>
		<h3>MySQL User2 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user2/list.do">목록이동</a>
		
		<form action="/ch10/user2/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birth" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" placeholder="아이디 입력"/></td>
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