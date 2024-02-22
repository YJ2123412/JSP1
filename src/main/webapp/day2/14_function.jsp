<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14_function</title>
</head>
<body>
<%
	String[] messages = "Hi_ Hello@ welcome".split(" ");
	String message = "I am Twice";
	out.print("문자열의 길이: "+ message.length());
	out.print("<br>");
	out.print("문자열의 위치: "+ message.indexOf("am"));
	out.print("<br>");
	out.print("문자열 대문자로 변경: "+ message.toUpperCase());
	out.print("<br>");
	out.print("특정 위치 문자 가져오기: "+ message.charAt(3));
	out.print("<br>");
	out.print("특정 문자열(am) 포함: "+ message.contains("am"));
	out.print("<br>");
	out.print("특정 문자열(are) 포함: "+ message.contains("are"));
	out.print("<br>");
	out.print("특정 문자열을 다른 문자열로 치환: "+message.replace("Twice", "Viviz"));
	out.print("<br>");
	out.print("문자열 공백으로 split한 결과: "+messages[0]+","+messages[1]+","+messages[2]);
	//치환 결과가 message 문자열을 변경하지는 않음, 치환한 결과만 리턴
	
	pageContext.setAttribute("msg",message);
	pageContext.setAttribute("msgArr",messages);
	%>
	
	
	
	<hr>
	<h3>위와 같은 문자열의 자바 메소드를 실행하는 함수 fn 테스트</h3>
	<hr>
	<p>core, fmt 라이브러리는 태그를 제공, fn 라이브러는 함수를 사용할 수 있게 함
		문자열 메소드의 결과값이 태그 안에서 출력되도록 함</p>
		<ul>
			<li><c:out value="${fn:length(msg)}"/></li>
			<li><c:out value="${fn:indexOf(msg,'am')}"/></li>
			<li><c:out value="${fn:toUpperCase(msg)}"/></li>
			<li><c:out value="${fn:substring(msg,3,6)}"/></li>
			<li><c:out value="${fn:contains(msg,'am')}"/></li>
			<li><c:out value="${fn:contains(msg,'are')}"/></li>
			<li><c:out value="${fn:replace(msg,'Twice','Viviz')}"/></li>
			<c:set value="he                llo           !" var="temp"/>
			<li><c:out value="${temp }"/>공백 하나만 출력되는 이유: html 문서에는 공백이 하나만 반영됨, 연속적으로 출력하고 싶은 경우 &nbsp;사용해야함 </li>
			<li><c:out value="${fn:replace(temp,' ','&nbsp;')}"/></li>
			<li>${fn:replace(temp,' ','&nbsp;')}</li>
			<!-- 리턴이 발생하는 split은 c:set 으로 실행, 리턴받을 var 정의 -->
			<c:set value="${fn:split(msg,' ')}" var="temps"/>
			
		</ul>
		<h4>msgArr 배열 애트리뷰트값을 하나씩 출력</h4>
		<ul>
			<c:forEach items ="${msgArr }" var="arr" varStatus="status">
				<li><c:out value="${arr }"/></li>
			</c:forEach>
		</ul>
		<h4>temps 배열 애트리뷰트값을 하나씩 출력</h4>
		<ul>
			<c:forEach items ="${temps }" var="arr2" varStatus="status">
				<li><c:out value="${arr2 }"/></li>
			</c:forEach>
		</ul>		
</body>
</html>