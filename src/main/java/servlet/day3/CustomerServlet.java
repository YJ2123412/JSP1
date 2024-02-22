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

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

@WebServlet(urlPatterns = {"/customers.cc"}, description="고객 전체 조회")
public class CustomerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);
	
	//고객전체 조회 요청은 a 태그 메뉴이므로 GET 방식 요청입니다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dao 실행하고 리턴받은 list를 로그로 찍어보기
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = dao.allCustomers();
		logger.info("[@,@] 전체 고객 조회: {}",list);
		
		//서블릿에서는 jdbc 관련된 실행만 하고, 조회결과는 jsp에서 웹페이지 만들어 확인
		//서블릿: 요청, 응답컨트롤러 / jsp: 뷰(view)
		
		//뷰(jsp)에 애트리뷰트 값을 저장해서 보내기
		//페이지 컨텍스트는 하나의 웹페이지 범위, request는 하나의 요청 범위로 애트리뷰트 저장.
		req.setAttribute("list",list);
		
		//뷰 jsp로 '요청'을 '전달-애트리뷰트'하고 화면을 전환(forward)해야 함
		RequestDispatcher dispqtcher = req.getRequestDispatcher("/day3/Customers.jsp");
		dispqtcher.forward(req, resp); //forward가 전달..
		//실행 브라우저: url: http://localhost:8088/jsp1/customers.cc
		// 화면 웹페이지는 customers.jsp
		
	}
	
}
