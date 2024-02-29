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
		<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/member/modify">회원정보 수정</a></li>
		<li><a href="${pageContext.request.contextPath}/product/list">상품 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/community/list">커뮤니티(게시판)</a></li>
		<li><a href="${pageContext.request.contextPath}/community/write">커뮤니티(글쓰기)</a></li>
		<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
		<li><a href="${pageContext.request.contextPath}/cart">장바구니</a></li>
		<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
		<li class="profile"><img alt="프로필" src="${pageContext.request.contextPath}/asset/img/puppy.jpg"></li>
	</ul>


</body>
</html>