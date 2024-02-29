<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css">

</head>
<body>
<%@ include file="header.jsp" %>
	<h2>마이페이지</h2>
	<h4><a href="../index.jsp">Home</a></h4>
	<h4><a href="./">./</a></h4>
	<h4><a href="../">../</a></h4>   <!-- 404  http://localhost:8088/ -->
	<h4><a href="../index">../index</a></h4> <!-- 404  http://localhost:8088/index -->
	<h4><a href="/jsp2_mvc">/jsp2_mvc/</a></h4>
</body>
</html>