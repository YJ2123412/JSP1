package home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.dao.MybatisProductDao;
import home.dto.ProductDto;


public class ProductListController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.selectAll();
		request.setAttribute("productList", list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
		dispatcher.forward(request, response);
	}

}
