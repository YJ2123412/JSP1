<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 등록</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/style.css">

<body>
<%@ include file="../header.jsp" %>
	<h2>물품 등록</h2>
    <h2>GET</h2>
	<form>
            <ul>
              <li>pcode</li>
              <li><input name="pcode" type="text"  placeholder="pcode를 입력해 주세요." /></li>
              <li>category</li>
              <li><input  name="category" type="text" placeholder="category를 입력해주세요(영문 2글자)" /></li>
              <li>상품 이름</li>
              <li><input name="pname" type="text" placeholder="상품 이름을 입력해 주세요." /></li>
              <li>가격</li>
              <li><input name="price" type="number" placeholder="가격을 입력해주세요(숫자 최대 9글자)" /></li>
            </ul>
            <button class="join-btn" id ="join">상품 등록하기</button>
    </form>
	<hr>
	<h2>POST</h2>
	<form action="" method="post">
            <ul>
              <li>pcode</li>
              <li><input name="pcode" type="text"  placeholder="pcode를 입력해 주세요." /></li>
              <li>category</li>
              <li><input  name="category" type="text" placeholder="category를 입력해주세요(영문 2글자)" /></li>
              <li>상품 이름</li>
              <li><input name="pname" type="text" placeholder="상품 이름을 입력해 주세요." /></li>
              <li>가격</li>
              <li><input name="price" type="number" placeholder="가격을 입력해주세요(숫자 최대 9글자)" /></li>
            </ul>
            <button class="join-btn" >상품 등록하기</button>
          </form>
  <script>
  document.getElementById('join').addEventListener('click', function() {
		document.forms[0].submit();})
  </script>
</body>
</html>