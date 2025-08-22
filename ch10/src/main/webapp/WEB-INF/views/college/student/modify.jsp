<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Student::modify</title>
	</head>
	<body>
		<h3>College/Student 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/list.do">목록이동</a>
		
		<form action="/ch10/college/student/modify.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdno" readonly value="${student.stdno}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${student.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" value="${student.birth}"/></td>					
				</tr>
				<tr>
					<td>학과</td>
					<td><input type="text" name="major" value="${student.major}" placeholder="학과 입력"/></td>
				</tr>
				<tr>
					<td>입학일</td>
					<td><input type="date" name="enr_date" value="${student.enr_date}"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>			
			</table>		
		</form>			
	</body>