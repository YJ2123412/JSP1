<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP2 MVC</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
	<h3>프론트 컨트롤러 테스트</h3>
	<hr>
	<p>url은 '확장자가 없는 형식'으로 만들어봅니다. 프로젝트에서는 '기능별로 폴더'를 만듭니다.
	jsp파일들을 member, community, product 폴더(예시)등에 저장합니다
	url도 하위폴더를 갖는 형식으로 해야 편합니다
	</p>
	<ul>
		<li><a href="member/join">회원가입</a></li>
		<li><a href="member/modify">회원정보 수정</a></li>
		<li><a href="product/list">상품 목록</a></li>
		<li><a href="community/list">커뮤니티(게시판)</a></li>
		<li><a href="community/write">커뮤니티(글쓰기)</a></li>
		<li><a href="mypage">마이페이지</a></li>
		<li><a href="cart">장바구니</a></li>
		<li><a href="login">로그인</a></li>
		<li>
			<form action="member/save" method="post">
				<input type="text" placeholder="테스트입니다." name="test">
				<button>POST 테스트</button>
			</form>
		</li>
	</ul>









</body>
</html>