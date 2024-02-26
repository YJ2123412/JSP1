<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>

<link rel="stylesheet" href="assets/css/style3.css">
</head>
<body>
	<h3>상품 조회 - day3 products.jsp에 검색기능 추가 </h3>
	<div class="search">
	<!-- form action이 없을때 동작은? 자기자신 url.. method 기본 값은 GET -->
		<form>
		<select name = "category">
			<option value="">카테고리 선택</option>
			<c:forEach items="${cateList }" var="cate" >
				<option value="${cate}"><c:out value ="${cate}"/></option>
			</c:forEach>	
		</select>
		<input type="text" name="keyword" placeholder="상품명 검색어 입력" value="">
		<span style = "padding-left:10px;">가격대별</span>
		<input type="text" name="from" placeholder="10000" value=""><b>~</b>
		<input type="text" name="to" placeholder="50000" value="">
		<button id="search" type="submit">조회</button>
		<button id="selectAll" type="button" onclick="location.href='search.cc'">전체보기</button>
		</form>
	</div>
	<hr>
	<ul>
		<c:forEach items="${list }" var="vo" varStatus="status" >
			<li>
				<ul class="row" style=" display:-webkit-box;">
					<li><c:out value="${vo.pcode}"/></li>
					<li><c:out value="${vo.category }"/></li>
					<li><c:out value="${vo.pname }"/></li>
					<li><fmt:formatNumber  value="${vo.price }"/></li>
				</ul>
			</li>
		</c:forEach>
	</ul>
	<script type="text/javascript" src="assets/js/search.js"></script>
	
</body>
</html>