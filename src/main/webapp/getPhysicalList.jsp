<%@page import="com.information.biz.physical.PhysicalVO"%>
<%@page import="java.util.List"%>
<%@page import="com.information.biz.physical.impl.PhysicalDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	PhysicalVO vo = new PhysicalVO();
	PhysicalDAO physicalDAO = new PhysicalDAO();
	List<PhysicalVO> physicalList = physicalDAO.getPhysicalList(vo);
%>

<!DOCTYPE html>	
<html>
<head>
<style>
	h1, h3, p{
	text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>신체 정보</title>
</head>
<body>
		<h1>신체 정보</h1>
		<h3>
			환영합니다
		</h3>

		<!-- 검색 시작 -->
		<form action="getPhysicalList.jsp" method="post">
			<table border="1" style="border: 1px solid black; height: 10px; margin: auto; text-align: center; width:700px;">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="WEIGHT">몸무게
							<option value="HEIGHT">키
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="검색" /></td>
				</tr>
			</table>
		</form>

		<!-- 검색 종료 -->

		<table border="1" style="border: 1px solid black; height: 10px; margin: auto; text-align: center;">
			<tr>
				<th bgcolor="red" width="100">번호</th>
				<th bgcolor="red" width="250">이름</th>
				<th bgcolor="red" width="70">성별</th>
				<th bgcolor="red" width="150">등록일</th>
				<th bgcolor="red" width="100">조회수</th>
			</tr>

			<%
				for(PhysicalVO physical : physicalList){
			%>
			<tr>
				<td><%= physical.getSeq() %></td>
				<td align="left">
					<a href="getPhysical.jsp?seq=<%= physical.getSeq() %>"> <%=physical.getName1() %></a>
				</td>
				<td><%= physical.getGender() %></td>
				<td><%= physical.getRegDate() %></td>
				<td><%= physical.getCnt() %></td>
			</tr>
			<%		
				}
			%>
		</table>
		<br> 
		<p><a href="insertPhysical.jsp">새로운 신체정보 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
			<a href="logout_proc.jsp">Log-out</a>
		</p>	
</body>
</html>