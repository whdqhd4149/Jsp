<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop/Product::register</title>
	</head>
	<body>
		<h3>Shop/Product 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/product/list.do">목록이동</a>
		
		<form action="/ch10/shop/product/register.do" method="post">
			<table border="1">
				
				<tr>
					<td>제품명</td>
					<td><input type="text" name="pname" placeholder="제품명 입력"/></td>
				</tr>
				<tr>
					<td>재고량</td>
					<td><input type="number" name="stock" placeholder="재고량 입력"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="number" name="price" placeholder="가격 입력"/></td>
				</tr>
				<tr>
				<tr>
					<td>제조회사</td>
					<td><input type="text" name="company" placeholder="제조회사 입력"/></td>
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