<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REST API 테스트</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<h2>능력 단위 평가_ 교과목: 중간 프로젝트</h2>
	<h3>작성자: 이예진</h3>
	
	<pre>
		
	  [판매 관리 시스템 구현 요구 사항입니다.]
	 
		
	  1) 서버와 동기식 통신을 하는 컨트롤러와 화면으로 아래 기능을 구현하세요.
	       a. 고객 등록
	       b. 고객 목록
	       
	  2) 서버와 비동기식 통신을 하는 REST API 컨트롤러와 Ajax 로  아래 기능을 구현하세요. (각 기능에 대해 SPA 방식으로 구현합니다.)
	       c. 상품 등록과 상품 조회
	       d. 구매 목록
	      
	  ※ 각 화면에 메뉴를 포함하는 header를 포함하도록 합니다.  </pre>
	<ul>
		<li><a href="member/list">고객 목록</a></li>
		<li><a href="member/join">고객 등록</a></li>
		<li><a href="products">상품관리</a></li>
		<li><a href="buys">구매 내역 관리</a></li>
	</ul>


</body>
</html>