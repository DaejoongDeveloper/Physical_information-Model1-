<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로운 신체 정보 등록</title>
</head>
<body>
	<h1>새로운 신체 정보 등록</h1>
	<a href="logout_proc_jsp">Log-out</a>
	<form action="insertPhysical_proc.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">이름</td><td align="left">
			<input type="text" name="name1" size="20"/></td>
	</tr>	
	<tr>
		<td bgcolor="orange">몸무게</td><td align="left">
		<input type="text" name="weight" size="20"/></td>
	</tr>	
	<tr>
		<td bgcolor="orange">키</td><td align="left">
		<input type="text" name="height" size="20"/></td>
	</tr>	
	<tr>
		<td bgcolor="orange">혈액형</td><td align="left">
		<input type="text" name="blood" size="20"/></td>
	</tr>	
	<tr>
		<td bgcolor="orange">성별</td><td align="left">
		<input type="text" name="gender" size="20"/></td>
	</tr>	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="새로운 신체 정보 등록"/></td>	
	</tr>		
	</table>
	</form>
	<hr>
	<a href="getPhysicalList.jsp">목록 가기</a>
</body>
</html>