<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1</title>
<!-- Css 파일 위치는 context path /jsp1/ 기준으로 함 -->
<link rel="stylesheet" href="assets/css/style2.css">

</head>
<body>
	<h3>고객 전체 조회</h3>
	<hr>
	<!-- list라는 이름의 애트리뷰트가 필요 ->애트리뷰트 저장은 서블릿에서 함  -->
	<ul>
		<c:forEach items="${list }" var="vo" varStatus="status" >
			<li>
				<ul>
					<li><c:out value="${fn:toUpperCase(vo.customId) }"/></li>
					<li><c:out value="${vo.name }"/></li>
					<li><c:out value="${vo.email }"/></li>
					<li><c:out value="${vo.age }"/></li>
					<li><fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/></li>
				</ul>
			</li>
		</c:forEach>
	</ul>



</body>
</html>