package day5.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;



@WebServlet(urlPatterns = {"/search.cc"}, description="상품 검색")
public class ProductSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductSearchServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		logger.info("[My Info]파라미터 확인: {},{},{},{}",category ,keyword,from,to);
		
		Map<String, Object> map = new HashMap<>();
		if(category !=null&& category.trim().length() !=0) {
			map.put("category", category);
		}
		if(keyword !=null&& !keyword.isEmpty()) {
			map.put("keyword",keyword.trim());
		}
		if(from !=null&& !from.isEmpty() && !to.isEmpty()&& to !=null) {
			map.put("from",from.trim());
			map.put("to",to.trim());
		}
		logger.info("[My Info]파라미터 map: {}",map);
		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(map);
		req.setAttribute("list", list);
		
		
		
		List<String> cateList = List.of("A1","A2","B1","B2","C1");	//todo dao에서 조회하기
		req.setAttribute("cateList", cateList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day5/Search.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	
}
