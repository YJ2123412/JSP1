package home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import home.dao.MybatisCustomerDao;
import home.dto.CustomerDto;



public class MemberListController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  MybatisCustomerDao dao = new MybatisCustomerDao(); 
		  List<CustomerDto> list = dao.selectAll(); 
		  request.setAttribute("list",list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../../webapp/member/list.jsp");
		dispatcher.forward(request, response);
	}
}
