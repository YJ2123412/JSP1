package servlet.day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

@WebServlet(urlPatterns = {"/register.cc"}, description="회원가입")
public class ResisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ResisterServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[MyInfo]고객 등록 화면 요청되었습니다.");
		//forward만 필요
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/register.jsp"); //req-> 매개변수명
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
		//나이가 필수 입력이 아니라면 값이 비어있을수 있음. 그때 parseint 확인 해보기 => 오류 발생
		int age = 0;
		//form 태그 요소에 name="age"가 있으므로 temp가 null일 경우는 없음 ->post에서는 입력요소가 있다면 무조건 공백으로라도 채워져있음/ get은 공백 O
		if(temp.length() !=0) age = Integer.parseInt(temp);
		
		//dao의 메소드 인자로 전달할 vo 객체 생성하기-join 메소드 
		 CustomerVo vo= new CustomerVo(userid, name, email, age, null);
		 logger.info("\t 입력값 vo: {}", vo);
		 
		 TblCustomerDao dao = new TblCustomerDao();
		 dao.join(vo); // pk 아이디 중복값있으면 무결성 오류 발생
		
		 //서버가 클라이언트에게 응답을 보냄 ->"customers.cc로 요청을 보내라
		 resp.sendRedirect("customers.cc");
		 //리다이렉트는 웹페이지의 js, out.print .. 출력 사용 불가능
		
		
		
		
		
		
		
		
		
	}
	
}