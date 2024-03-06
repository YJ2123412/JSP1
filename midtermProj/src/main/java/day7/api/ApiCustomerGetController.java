package day7.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomer;
import day4.mybatis.dto.CustomerDto;

//@Slf4j
public class ApiCustomerGetController implements Controller {
	public static final Logger logger = LoggerFactory.getLogger(ApiCustomerGetController.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MybatisCustomer dao = new MybatisCustomer();
		CustomerDto dto = dao.getCustomer(request.getParameter("id"));
		//log.info("searchId dto: {}",dto);
		
		
		//자바객체를 json 문자열로 변환
		//1) 아이디 중복검사가 아닌, 고객 정보 조회용
		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); String jsonData = null;
		 * jsonData = objectMapper.writeValueAsString(dto);
		 * logger.info("전송할 json문자열: {}", jsonData);
		 */
		
		//2)아이디 중복검사인 경우에는 json으로 있다 없다에 대한 값으로 전달하기
		int result = 0;
		if(dto!=null)result=1;
		String jsonData2 = "{\"result\" : "+result+"}";
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonData2);
		
		
	}	
		
		
}


