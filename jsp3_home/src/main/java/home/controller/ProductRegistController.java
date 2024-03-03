package home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.dao.MybatisProductDao;
import home.dto.ProductDto;


public class ProductRegistController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String method = request.getMethod();
		if(method.equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("regist.jsp");
			dispatcher.forward(request, response);
		}else if(method.equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String pcode = request.getParameter("pcode");
		String category = request.getParameter("category");
		String pname = request.getParameter("pname");
		String temp = request.getParameter("price");
		int price = 0;
		if(temp.length() != 0) price= Integer.parseInt(temp);
		MybatisProductDao dao = new MybatisProductDao();
		int result = dao.insert(new ProductDto(pcode, category, pname, price));
		String message="상품 등록이 완료되었습니다";
		if(result==0) {
			message="상품 등록 오류가 생겼습니다.";
			response.setContentType("text/html; charset=UTF-8");
		}
		response.sendRedirect("productlist");}
		else {System.out.println("잘못됨");}
	}
}
