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
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>물품 목록</h2>
		<div class="search">
		<form>
		<select name = "category">
			<option value="">카테고리 선택</option>
			<c:forEach items="${cateList}" var="cate" >
				<option value="${cate.code}" ><c:out value ="${cate.name}"/></option>
			</c:forEach>	
		</select>
		<input type="text" name="keyword" placeholder="상품명 검색어 입력" value="${keyword }">
		<span style = "padding-left:10px;">가격대별</span>
		<input type="text" name="from" placeholder="10000" value="${from }"><b>~</b>
		<input type="text" name="to" placeholder="50000" value="${to }">
		<button id="search" type="submit">조회</button>
		<button id="selectAll" type="submit">전체보기</button>
		</form>
	</div>
	<hr>
	<ul >
		<c:forEach items="${list}" var="dto" varStatus="status"  >
			<li>
				<ul id="row" style="display:-webkit-box;">
					<li class="row"><c:out value="${dto.pcode}"/></li>
					<li class="row"><c:out value="${dto.category }"/></li>
					<li class="row"><c:out value="${dto.pname }"/></li>
					<li class="row"><fmt:formatNumber  value="${dto.price }"/></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
	<script type="text/javascript">
		const temp='${cate}';
	
	</script>	
	<script type="text/javascript">
	
	const category = document.querySelector('select[name="category"]');
	const keyword = document.querySelector('input[name="keyword"]');
	const from = document.querySelector('input[name="from"]');
	const to = document.querySelector('input[name="to"]');
	
	<%
	MybatisProductDao dao = new MybatisProductDao();
	
	
	%>
	console.log(temp);
	//카테고리 조회시에만 temp값이 null이 아님
		if(temp!=null) category.value=temp;
		
			document.getElementById('search').addEventListener('click',()=>{
				let isValid = true;
				if(keyword.value.length == 0 && category.value.length ==0 
				&& from.value.length==0 && to.value.length ==0){
					isValid=false
					alert('검색어를 입력하세요');}
			
				if(isValid){
					
					document.forms[0].submit();}
		})
		
		document.getElementById('searchAll').addEventListener('click',()=>{
					document.forms[0].submit();
		})
	
	</script>
	
	
	
	
	
</body>
</html>