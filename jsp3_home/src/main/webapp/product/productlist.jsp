<%@page import="home.dao.MybatisProductDao"%>
<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css">
<style>
ul.ullist {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}
li.lilist{
    width: 800px;
}
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>물품 목록</h2>
		<ul class="ullist" >
		<c:forEach items="${productList}" var="vo" varStatus="status">
			<li class="lilist">
				<ul class="row">
					<li><c:out value="${status.index+1 }" /></li>
					<li><c:out value="${fn:toUpperCase(vo.pcode) }" /></li>
					<li><c:out value="${vo.category }" /></li>
					<li><c:out value="${vo.pname }" /></li>
					<li><c:out value="${vo.price }" /></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
</body>
</html>