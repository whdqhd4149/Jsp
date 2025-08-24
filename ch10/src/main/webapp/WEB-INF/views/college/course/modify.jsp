<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Course::modify</title>
	</head>
	<body>
		<h3>College/Course 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/course/list.do">목록이동</a>
		
		<form action="/ch10/college/course/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="number" name="cs_id" readonly value="${course.cs_id}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>과목</td>
					<td><input type="text" name="cs_name" value="${course.cs_name}" placeholder="과목 입력"/></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><input type="number" name="cs_credit" value="${course.cs_credit}" placeholder="학점 입력"/></td>
				</tr>
				<tr>
					<td>학과</td>
					<td><input type="text" name="cs_dept" value="${course.cs_dept}" placeholder="학과 입력"/></td>
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