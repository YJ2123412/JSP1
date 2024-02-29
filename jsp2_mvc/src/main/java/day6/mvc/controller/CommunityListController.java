package day6.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommunityListController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//정상코드 - RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		//없는 jsp 요청하므로 404상태코드 ->error.html 페이지 표시(web.xml)
		RequestDispatcher dispatcher = request.getRequestDispatcher("lists.jsp");
		dispatcher.forward(request, response);
	}
}
