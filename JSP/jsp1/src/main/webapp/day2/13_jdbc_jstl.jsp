<%@page import="project.dao.TblCustomerDao"%>
<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

	#table{display:flex; align-content:center;  justify-content: center; padding:2rem;border:1px; border-color: gray;
	}
	td,th{
	border: thin; border-color: gray; text-align: center; padding:1rem; 
	}
</style>
<title>13_jbcd_jstl</title>
</head>
<body>
	<h3>2번 소스파일 스크립트릿과 출력식을 jstl과 el로 변경하기</h3>
	<hr>
<%
	TblCustomerDao dao= new TblCustomerDao();
	List<CustomerVo> list= dao.allCustomers();
	pageContext.setAttribute("list", list);
%>
	<fmt:setLocale value="ko_kr"/> 
	<c:set var="reg_date" value="<%=list.get(5)%>"/>
	<table id="table">
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>나이</th>
		<th>가입날짜</th>
		
		<c:forEach items="${list }" var="vo" varStatus="status" >
			<tr>
				<td><c:out value="${fn:toUpperCase(vo.customId) }"/></td>
				<td><c:out value="${vo.name }"/></td>
				<td><c:out value="${vo.email }"/></td>
				<td><c:out value="${vo.age }"/></td>
				<td><fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>
	<table>
	</table>

</body>
</html>
