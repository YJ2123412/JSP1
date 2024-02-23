package servlet.day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;

@WebServlet(urlPatterns = {"/productReg.cc"}, description="물품등록")
public class ProductReg extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductReg.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[ProductInfo]물품 등록 화면 요청되었습니다.");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/productReg.jsp"); //req-> 매개변수명
		dispatcher.forward(req, resp);
		
	}
	
	//register.jsp 화면에서 입력된 값을 post 방식으로 전달받기
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//POST 요청값 인코딩 필수
		req.setCharacterEncoding("UTF-8");
		
		logger.info("[ProductInfo]물품 데이터 저장이 요청되었습니다.");
		String pcode = req.getParameter("pcode");
		String category = req.getParameter("category");
		String pname = req.getParameter("pname");
		String temp = req.getParameter("price");
		
		int price = 0;
		if(temp.length() != 0) price= Integer.parseInt(temp);
		
		 
		TblProductDao dao = new TblProductDao();
		int result = dao.insert(pcode, category, pname, price);
		
		logger.info("\t 입력값 vo: {}", dao);
		 //서버가 클라이언트에게 응답을 보냄 ->"customers.cc로 요청을 보내라
		// resp.sendRedirect("products.cc");
		 //리다이렉트는 웹페이지의 js, out.print .. 출력 사용 불가능
		
		String message="상품 등록이 완료되었습니다";
		if(result==0) {
			message="상품 등록 오류가 생겼습니다.";
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('"+message+"');");
			out.print("location.href='products.cc';");
			out.print("</script>");
			
		}
		
	}
}