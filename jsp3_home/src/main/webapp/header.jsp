<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul{
		list-style:none; align-items: center; justify-content: space-around; padding: 20px; display:flex; border-bottom: 3px solid gray;
	}
	li{
		padding: 20px;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<ul>
		<li><a href=<%=request.getContextPath()%>><strong>HOME</strong></a></li>
		<li><a href="${pageContext.request.contextPath}/member/list">회원 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/member/join">회원 등록</a></li>
		<li><a href="${pageContext.request.contextPath}/product/list">물품 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/product/regist">물품 등록</a></li>
	</ul>
</body>
</html>