package day7.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dto.CustomerDto;


public class MemberJoinController implements Controller{
	    private static final long serialVersionUID = 1L;
	    private static final Logger logger = LoggerFactory.getLogger(MemberJoinController.class);

	    @Override
	    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        int result = 0;
	        String method = request.getMethod();

	        if (method.equals("GET")) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("join.jsp");
	            dispatcher.forward(request, response);
	        } else if (method.equals("POST")) {
	            logger.info("[MyInfo]고객 데이터 저장이 요청되었습니다.");
	            String CUSTOM_ID = request.getParameter("CUSTOM_ID");
	            String NAME = request.getParameter("NAME");
	            String EMAIL = request.getParameter("EMAIL");
	            String temp = request.getParameter("AGE");
	            int AGE = 0;
	            if (temp.length() != 0)
	                AGE = Integer.parseInt(temp);

	            CustomerDto dto = new CustomerDto(CUSTOM_ID, NAME, EMAIL, AGE, null);
	            logger.info("\t 입력값 dto: {}", dto);

	            try {
					MybatisCustomerDao dao = new MybatisCustomerDao();
					dao.insert(dto);
					result = 1;
				} catch (Exception e) {
					e.printStackTrace();
					result=0;
				}

	        }
	        
	        String message="고객 등록이 완료되었습니다";
			if(result==0) {
				message="고객 등록 오류가 생겼습니다.";
			}
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('"+message+"');");
				out.print("location.href='join';");
				out.print("</script>");
				
			}
	    }
	

