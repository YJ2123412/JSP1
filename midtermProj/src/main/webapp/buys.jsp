<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 내역</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/modal.css">
<style>
li{ text-align: center; }
</style>
</head>
<body>
<%@ include file="header.jsp" %>
   <h3>구매 내역</h3>
   <hr>
   <ul id="list">
      <li class="list-header">
         <ul class="row" >
            <li class="index">No</li>
            <li class="customid">구매자 ID</li>
            <li class="pcode">상품 코드</li>
            <li class="quantity">구매 갯수</li>
            <li class="buy_Date">구매 날짜</li>
         </ul>
      </li>
   </ul>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   	<script type="text/javascript">
      //const modal = new bootstrap.Modal(document.querySelector('.modal'));
      //modal.show();
      //const temp = '${category}';
  	 </script>
  	 <script type="text/javascript" src="assets/js/buyApi_list.js"></script>
</body>
</html>