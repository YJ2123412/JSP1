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
				<option value="${cate.code}" ><c:out value ="${cate.name}"/></option>
			</c:forEach>	
		</select>
		<input type="text" name="keyword" placeholder="상품명 검색어 입력" value="${keyword }">
		<span style = "padding-left:10px;">가격대별</span>
		<input type="text" name="from" placeholder="10000" value="${from }"><b>~</b>
		<input type="text" name="to" placeholder="50000" value="${to }">
		<button id="search" type="submit">조회</button>
		<button id="selectAll" type="button" onclick="location.href='search.cc'">전체보기</button>
		</form>
	</div>
	<hr>
	<ul >
		<c:forEach items="${list }" var="vo" varStatus="status"  >
			<li  >
				<ul id="row"  style=" display:-webkit-box;">
					<li class="row"><c:out value="${vo.pcode}"/></li>
					<li class="row"><c:out value="${vo.category }"/></li>
					<li class="row"><c:out value="${vo.pname }"/></li>
					<li class="row"><fmt:formatNumber  value="${vo.price }"/></li>
				</ul>
				
			</li>
		</c:forEach>
	</ul>
	<script type="text/javascript">
	//js 파일에서는 서버 애트리뷰트를 가져올 수 없음->jsp 파일 안에 있는 script 태그 안에서는 가능
	//temp 값->search.js와 공유
		const temp='${cate}';
	</script>	
	<script type="text/javascript" src="assets/js/search.js">
	</script>
	
</body>
</html>