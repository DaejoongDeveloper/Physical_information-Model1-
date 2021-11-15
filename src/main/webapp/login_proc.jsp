<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.information.biz.user.UserVO" %>
<%@page import="com.information.biz.user.impl.UserDAO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
	// 사용자 정보
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// DB연동
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//화면
	if(user != null){
		response.sendRedirect("getPhysicalList.jsp");
	}else {
		response.sendRedirect("login.jsp");	
	}
%>