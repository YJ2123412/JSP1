<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="project.vo.CustomerVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_forEach_List</title>
</head>
<body>
	<!--7. 자바 객체의 컬렉션(list) 활용하기  -->
		<h5>자바 객체의 컬렉션(list) 활용하기</h5>
		<%	//jdbc로 sql 조회한 결과 List인 경우 활용 가능
			List<CustomerVo> list = List.of(new CustomerVo("momo12","강모모","momo12@daum.net",25,null),
											new CustomerVo("momo13","강모모","momo13@daum.net",26,null),
											new CustomerVo("momo14","강모모","momo14@daum.net",27,null),
											new CustomerVo("momo15","강모모","momo15@daum.net",28,null));
					
			pageContext.setAttribute("list",list);
		%>
		<!-- 컬렉션 list에서 값을 하나씩 가져와 애트리뷰트 이름 vo에 저장 -->
		<c:forEach items="${list }" var="vo" varStatus="status">
			<c:out value="${status.index }"/>, <c:out value="${vo }"/>
			<!--varStatus 속성 index는 지금처럼 items 로 컬렉션 다룰 때 사용  -->
			<!--vo에 저장된 객체 속성을 각각 출력하기  -->
			<ul>
				<li><c:out value="${vo.customId }"/></li>
				<li><c:out value="${vo.name }"/></li>
				<li><c:out value="${vo.email }"/></li>
				<li><c:out value="${vo.age }"/></li>
			</ul>
		</c:forEach>






</body>
</html>