<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생등록</title>
	</head>
	<body>
		<h3>학생등록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/student/list.do">목록이동</a>
		
		<form action="/ErdCollege/student/list.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdno" placeholder="학번 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="stdname" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="stdhp" placeholder="휴대폰 입력(- 포함)"/></td>
				</tr>
				<tr>
					<td>학년</td>
					<td><input type="number" name="stdyear" placeholder="학년 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="date" name="stdaddress" placeholder="주소 입력"/></td>
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