<%@page import="project.dao.TblCustomerDao"%>
<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_insert</title>
</head>
<body>
<p>2번 조회결과 확인과 같이 이번에는 insert 실행</p>
<%
	TblCustomerDao dao = new TblCustomerDao();

	CustomerVo vo = new CustomerVo("sanaa","김사나","sanaa@gamil.com",23,null);
	dao.join(vo);
%>
	

	<hr>
	<h4>CustomerVo 객체</h4>
	<table style="width :600px;">
		<tr>
		 	<th>아이디</th>
		 	<th>이름</th>
		 	<th>이메일</th>
		 	<th>나이</th>
		 	<th>가입날짜</th>
		</tr>
		<tr>
			<td><%=vo.getCustomId() %></td>
			<td><%=vo.getCustomId() %></td>
			<td><%=vo.getEmail() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getReg_date() %></td>
		</tr>
	</table>
	<a href="2_jdbc.jsp">전체 고객조회</a>
</body>
</html>

<!--단축키: crtl+d 한줄삭제, ctrl+alt+방향키(한줄복사), alt+방향키 줄이동, shift+엔터: 중간에 다음줄이동  -->
