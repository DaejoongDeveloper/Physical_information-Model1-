<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.information.biz.physical.impl.PhysicalDAO" %>
<%@ page import="com.information.biz.physical.PhysicalVO" %>


<% 
	// 입력 정보
	request.setCharacterEncoding("UTF-8");
	String name1 = request.getParameter("name1");
	String weight = request.getParameter("weight");
	String height = request.getParameter("height");
	String blood = request.getParameter("blood");
	String gender = request.getParameter("gender");
	String seq = request.getParameter("seq");
	
	// DB 연동
	PhysicalVO vo = new PhysicalVO();
	vo.setName1(name1);
	vo.setWeight(weight);
	vo.setHeight(height);
	vo.setBlood(blood);
	vo.setGender(gender);
	vo.setSeq(Integer.parseInt(seq));
	
	PhysicalDAO physicalDAO = new PhysicalDAO();
	physicalDAO.updatePhysical(vo);
	
	// 화면
	response.sendRedirect("getPhysicalList.jsp");
%>
	