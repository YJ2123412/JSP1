<%@page import="project.dao.TblCustomerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6_selectBy</title>
</head>
<body>


<%
	TblCustomerDao dao = new TblCustomerDao();
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	List<CustomerVo> list = null;
	
	if((name !=null && name.length()!=0)&&(temp!=null && temp.length() !=0)){
		int age = Integer.parseInt(temp);
		list = dao.selectBy(name, age);
		out.print(list);
		if(list.size()==0) out.print("<h4>조회결과가 없습니다</h4>");
	} else{
		out.print("파라미터 값을 모두 입력하세요");
	}
%>
</body>
</html>