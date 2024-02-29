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
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>회원 목록</h2>
	
	<ul>
		<c:forEach items="${list }" var="dto" varStatus="status" >
			<li>
				<ul>
					<li><c:out value="${dto.customId }"/></li>
					<li><c:out value="${dto.name }"/></li>
					<li><c:out value="${dto.email }"/></li>
					<li><c:out value="${dto.age }"/></li>
					<li><fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
</body>
</html>