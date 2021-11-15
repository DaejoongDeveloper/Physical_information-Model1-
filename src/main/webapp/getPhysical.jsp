<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.information.biz.physical.PhysicalVO" %>
<%@page import="com.information.biz.physical.impl.PhysicalDAO" %>
<% 
	// 게시글 번호 추출
	String seq = request.getParameter("seq");

	PhysicalVO vo = new PhysicalVO();
	vo.setSeq(Integer.parseInt(seq));
	
	PhysicalDAO physicalDAO = new PhysicalDAO();
	PhysicalVO physical = physicalDAO.getPhysical(vo);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신체 정보 상세보기</title>
</head>
<body>
	<h1>신체 정보 상세보기</h1>
		<a href="logout_proc.jsp">Log-out</a>
		<hr>
		<form action="updatePhysical_proc.jsp" method="post">
		<input name="seq" type="hidden" value="<%= physical.getSeq() %>"/>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">이름</td>
					<td align="left"><input name="name1" type="text"
						value="<%=physical.getName1()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">몸무게</td>
					<td align="left"><input name="weight" type="text"
						value="<%=physical.getWeight()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">키</td>
					<td align="left"><input name="height" type="text"
						value="<%=physical.getHeight()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">혈액형</td>
					<td align="left"><input name="blood" type="text"
						value="<%=physical.getBlood()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">성별</td>
					<td align="left"><input name="gender" type="text"
						value="<%=physical.getGender()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%=physical.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=physical.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertPhysical.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deletePhysical_proc.jsp?seq=<%=physical.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getPhysicalList.jsp">글목록</a>
	</body>
</html>