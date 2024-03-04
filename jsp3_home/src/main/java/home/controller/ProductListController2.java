package home.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import home.dao.MybatisProductDao;
import home.dto.ProductDto;

public class ProductListController2 implements Controller{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductListController2.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		String method = "GET";
		if(method.equals(request.getMethod())){*/
			
			String category = request.getParameter("category");
			String keyword = request.getParameter("keyword");
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			logger.info("[My Info]파라미터 확인: {},{},{},{}",category ,keyword,from,to);
			
			Map<String, Object> map = new HashMap<>();
			if(category !=null&& category.trim().length() !=0) {
				map.put("category", category);
				request.setAttribute("cate", category);
			}
			if(keyword !=null&& keyword.trim().length()!=0) {
				map.put("keyword",keyword.trim());
				request.setAttribute("keyword", keyword);
			}
			if(from !=null&& from.trim().length() !=0 && to.trim().length() !=0&& to !=null) {
				map.put("from",from.trim());
				map.put("to",to.trim());
				request.setAttribute("from", from);
				request.setAttribute("to", to);
			}
			logger.info("[My Info]파라미터 map: {}",map);
			
			MybatisProductDao dao = new MybatisProductDao();
			List<ProductDto> list = dao.search(map);
			request.setAttribute("list", list);
			
			List<home.dto.CateDto> cateList = dao.getCategories();
			request.setAttribute("cateList", cateList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("productlist2.jsp");
			dispatcher.forward(request, response);
	/*		} else if(!method.equals(request.getMethod())){
				System.out.println("POST");
			}*/
		}
	}

