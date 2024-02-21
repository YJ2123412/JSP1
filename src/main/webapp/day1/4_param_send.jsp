<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4_parameter_send</title>
</head>
<body>
	<h3>a 태그의 url 주소에 파라미터 값을 포함해서 전송하기</h3>
	<p>중요!! 이것은 메뉴 또는 조회 동작을 할 때 사용되는 방식</p>
	<hr>
	<ul>
		<li><a href="5_param_receive.jsp?name=sana&age=24">name, age 2개의 파라미터 보내기</a></li>
		<li><a href="5_param_receive.jsp?name=sana">name, age 2개의 파라미터 보내기-age 파라미터 없음</a></li>
		<li><a href="5_param_receive.jsp?name=sana&age=">name, age 2개의 파라미터 보내기-age값 없음</a></li>
		<li><a href="5_param_receive.jsp?name=사나&age=">name 한글, age 2개의 파라미터 보내기-age값 없음</a></li>
	</ul>
	<hr>
	<h3>테이블에서 조회하기</h3>
	<ul>
		<li><a href="6_selectBy.jsp?name=김사나&age=23">name, age(23) 2개의 파라미터 보내기</a></li>
		<li><a href="6_selectBy.jsp?name=김사나&age=24">name, age(24) 2개의 파라미터 보내기</a></li>
		<li><a href="6_selectBy.jsp?name=김사나">name, age 2개의 파라미터 보내기-age 파라미터 없음</a></li><!--age=null  -->
		<li><a href="6_selectBy.jsp?name=sana&age=">name, age 2개의 파라미터 보내기-age값 없음</a></li><!--age= ''-->
		<li><a href="6_selectBy.jsp?name=사나&age=">name 한글, age 2개의 파라미터 보내기-age값 없음</a></li>
	</ul>



</body>
</html>