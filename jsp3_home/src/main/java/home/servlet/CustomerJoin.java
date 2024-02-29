package home.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import home.dao.MybatisCustomerDao;
import home.dto.CustomerDto;


public class CustomerJoin {
	@WebServlet(urlPatterns = {"/jsp3_home/member/list"}, description="회원가입")
	public class ResisterServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;
		private static final Logger logger = LoggerFactory.getLogger(ResisterServlet.class);
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			logger.info("[MyInfo]고객 등록 화면 요청되었습니다.");
			//forward만 필요
			RequestDispatcher dispatcher = req.getRequestDispatcher("./../../webapp/member/list.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		//register.jsp 화면에서 입력된 값을 post 방식으로 전달받기
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//POST 요청값 인코딩 필수
			req.setCharacterEncoding("UTF-8");
			
			logger.info("[MyInfo]고객 데이터 저장이 요청되었습니다.");
			String userid = req.getParameter("userid");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String temp = req.getParameter("age");
			int age = 0;
			if(temp.length() !=0) age = Integer.parseInt(temp);
			
			 CustomerDto dto= new CustomerDto(temp, name, email, age, null);
			 logger.info("\t 입력값 dto: {}", dto);
			 
			 MybatisCustomerDao dao = new MybatisCustomerDao();
			 dao.insert(dto); 
			
			 resp.sendRedirect("./../../webapp/member/list.jsp");
			
		}
		
	}
}
