<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank/Account::register</title>
	</head>
	<body>
		<h3>Bank/Account 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/account/list.do">목록이동</a>
		
		<form action="/ch10/bank/account/register.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="acc_no" placeholder="계좌번호 입력"/></td>
				</tr>
				<tr>
					<td>상품구분</td>
					<td><input type="text" name="acc_type" placeholder="상품구분 입력"/></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="acc_name" placeholder="상품명 입력"/></td>
				</tr>
				<tr>
					<td>고객번호</td>
					<td><input type="text" name="acc_cid" placeholder="고객번호 입력"/></td>
				</tr>
				<tr>
					<td>현재잔액</td>
					<td><input type="number" name="acc_balance" placeholder="현재잔액 입력"/></td>
				</tr>
				<tr>
					<td>개설일</td>
					<td><input type="date" name="acc_date"/></td>
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