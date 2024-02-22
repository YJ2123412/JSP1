package servlet.day3;
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
import project.dao.TblBuyDao;
import project.vo.BuyVo;

@WebServlet(urlPatterns = {"/buys.cc"}, description="구매 이력 조회")
public class BuyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BuyServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	TblBuyDao dao = new TblBuyDao();
	List<BuyVo> list = dao.selectAll();
	logger.info("[^^] 주문 리스트: {}",list);
	
	req.setAttribute("list",list);
	RequestDispatcher dispqtcher = req.getRequestDispatcher("/day3/Buys.jsp");
	dispqtcher.forward(req, resp);
		
		
		
	}
	
	
}
