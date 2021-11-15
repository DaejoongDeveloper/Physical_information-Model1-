<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "com.information.biz.physical.impl.PhysicalDAO" %>
    <%@page import = "com.information.biz.physical.PhysicalVO" %>

<%
	// 사용자 입력 정보
	String seq = request.getParameter("seq");
	
	// DB 연동
	PhysicalVO vo = new PhysicalVO();
	vo.setSeq(Integer.parseInt(seq));
	
	PhysicalDAO physicalDAO = new PhysicalDAO();
	physicalDAO.deletePhysical(vo);
	
	// 화면
	response.sendRedirect("getPhysicalList.jsp");
%>