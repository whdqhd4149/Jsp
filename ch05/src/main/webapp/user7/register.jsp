<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user7::register</title>
	</head>
	<body>
		<h3>User7 등록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/register.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="number" name="id" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" placeholder="숫자 입력"/></td>					
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" placeholder="이메일 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>						
			</table>		
		</form>		
	</body>
</html>