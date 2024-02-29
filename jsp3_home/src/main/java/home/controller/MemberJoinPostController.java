package home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import home.dao.MybatisCustomerDao;
import home.dto.CustomerDto;

public class MemberJoinPostController implements Controller{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberJoinPostController.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		logger.info("[MyInfo]고객 데이터 저장이 요청되었습니다.");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String temp = request.getParameter("age");
		int age = 0;
		if(temp.length() !=0) age = Integer.parseInt(temp);
		
	
		 CustomerDto dto= new CustomerDto(temp, name, email, age, null);
		 logger.info("\t 입력값 vo: {}", dto);
		 
		 MybatisCustomerDao dao = new MybatisCustomerDao();
		 dao.insert(dto); 
		
		 //리다이렉트는 웹페이지의 js, out.print .. 출력 사용 불가능
		RequestDispatcher dispatcher = request.getRequestDispatcher("join.jsp");
		dispatcher.forward(request, response);
	}
}
