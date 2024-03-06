<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>회원 목록</h2>
	
	<ul class="ullist" >
		<c:forEach items="${list}" var="dto" varStatus="status" >
			<li class="lilist">
				<ul class="row" >
					<li><c:out value="${dto.CUSTOM_ID}"/></li>
					<li><c:out value="${dto.NAME}"/></li>
					<li><c:out value="${dto.EMAIL}"/></li>
					<li><c:out value="${dto.AGE}"/></li>
					<li><fmt:formatDate value="${dto.REG_DATE}" pattern="yyyy-MM-dd a hh:mm:ss"/></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
</body>
</html>