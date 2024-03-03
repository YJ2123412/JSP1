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
<link rel="stylesheet" href="/jsp3_home/asset/css/style.css">
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
	<h2>회원 목록</h2>
	
	<ul class="ullist" >
		<c:forEach items="${memberlist}" var="dto" varStatus="status" >
			<li class="lilist">
				<ul >
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