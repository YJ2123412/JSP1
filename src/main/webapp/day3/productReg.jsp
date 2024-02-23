<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
</head>
<body>
	  <div class="contents-wrap">
  	<h3 style="text-align:center;">상품 등록</h3>
  	<hr>
          <form action="productReg.cc" method="post">
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
        </div>
  <script src="assets/js/script.js"></script>
</body>
</html>