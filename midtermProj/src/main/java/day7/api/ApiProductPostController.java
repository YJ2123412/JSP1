package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomer;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiProductPostController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		InputStream inputStream = request.getInputStream(); //http 전송방식의 입력스트림 생성, 요청 객체로 만들어짐
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		
		StringBuffer sb = new StringBuffer(); //String 은 불변객체이므로 +연결을 대신하는 메소드를 사용하기 위해 필요
		String line =null;
		
		while((line = br.readLine()) != null) { //입력스트림으로부터 1줄씩 읽어옴
			sb.append(line);
			log.info("line: {}", line);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		ProductDto dto = objectMapper.readValue(sb.toString(),ProductDto.class);
		log.info("변환된 dto: {}",dto);
		
		//dao에서 insert
		int result=0;
		try {
			MybatisProductDao dao = new MybatisProductDao(); 
			result = dao.insert(dto);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("dao insert 예외: {}",e.getMessage());
		}
		 
		 //insert 결과에 대한 응답을 보내기
		//방법2: json 문자열로 result 값 보내기
		String jsonData = "{\"result\" : "+result+"}";
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonData);
	}
}
		