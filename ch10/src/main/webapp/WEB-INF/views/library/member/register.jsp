<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Library/Member::register</title>
	</head>
	<body>
		<h3>Library/Member 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/member/list.do">목록이동</a>
		
		<form action="/ch10/library/member/register.do" method="post">
			<table border="1">
				<tr>
					<td>회원번호</td>
					<td><input type="number" name="member_id" placeholder="회원번호 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" placeholder="휴대폰 입력(-포함)"/></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td><input type="date" name="join_date"/></td>
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