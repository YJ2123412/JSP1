<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="../assets/css/customers.css">

<body>
<%@ include file="../header.jsp" %>
	<h2>회원가입</h2>
	<hr>
	<form action=""  method="post">
            <ul class="join-wrap">
              <li>아이디</li>
              <li><input name="CUSTOM_ID" type="text"  placeholder="아이디를 입력해 주세요.(최대 20글자)" /></li>
              <li>이름</li>
              <li><input  name="NAME" type="text" placeholder="이름(최대 영문 40글자, 한글 13글자)" /></li>
              <li>이메일</li>
              <li><input name="EMAIL" type="text" placeholder="이메일을 입력해 주세요.(최대 40글자)" /></li>
              <li>나이</li>
              <li><input name="AGE" type="text" placeholder="나이(숫자 최대 3글자)" /></li>
            </ul>
            <button class="join-btn" id="join" >회원가입</button>
          </form>
        <hr>
</body>
</html>