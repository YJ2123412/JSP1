package home.servlet;


	import java.io.IOException;
	import java.util.List;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

import home.dao.MybatisProductDao;
import home.dto.ProductDto;

	@WebServlet(urlPatterns = {"/list"}, description="상품 전체 조회")
	public class ProductServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;
		private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			MybatisProductDao dao = new MybatisProductDao();
			List<ProductDto> list = dao.selectAll();
			logger.info("[@,@] 전체 목록 조회: {}",list);
			
			req.setAttribute("list",list);
			
			RequestDispatcher dispqtcher = req.getRequestDispatcher("./../../webapp/product/list.jsp");
			dispqtcher.forward(req, resp);
			
		}
		
	}