package home.servlet;

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

import home.dao.MybatisProductDao;
import home.dto.CateDto;
import home.dto.ProductDto;



@WebServlet(urlPatterns = {"/search.cc"}, description="물품 검색")
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
			req.setAttribute("cate", category);
		}
		if(keyword !=null&& keyword.trim().length()!=0) {
			map.put("keyword",keyword.trim());
			req.setAttribute("keyword", keyword);
		}
		if(from !=null&& from.trim().length() !=0 && to.trim().length() !=0&& to !=null) {
			map.put("from",from.trim());
			map.put("to",to.trim());
			req.setAttribute("from", from);
			req.setAttribute("to", to);

		}
		logger.info("[My Info]파라미터 map: {}",map);
		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(map);
		req.setAttribute("list", list);
		
		
		List<CateDto> cateList = dao.getCategories();
		req.setAttribute("cateList", cateList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("./../../webapp/product/list.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	
}
