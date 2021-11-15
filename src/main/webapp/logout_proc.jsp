<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	// 객체 강제 종료
	session.invalidate();
	
	// 종료후 메인으로 이동
	response.sendRedirect("login.jsp");
%>