package servlet.day3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

@WebServlet(urlPatterns = {"/customers.cc"}, description="고객 전체 조회")
public class CustomerServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);
	
	//고객전체 조회 요청은 a 태그 메뉴이므로 GET 방식 요청입니다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dao 실행하고 리턴받은 list를 로그로 찍어보기
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = dao.allCustomers();
		logger.info("[@,@] 전체 고객 조회: {}",list);
		
		
		
		
		
	}
	
}
