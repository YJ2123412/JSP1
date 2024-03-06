package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public class ApiProductSearchController implements Controller {
	public static final Logger log = LoggerFactory.getLogger(ApiProductSearchController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//json 문자열 읽어오기 (post 방식..)
		request.setCharacterEncoding("UTF-8");
		
		InputStream inputStream = request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		StringBuffer sb = new StringBuffer(); 
		String line =null;
		
		while((line = br.readLine()) != null) { //입력스트림으로부터 1줄씩 읽어옴
			sb.append(line);
			log.info("line: {}", line);
		}
		
		//읽어온 json 문자열을 Map 자바 객체로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		
		@SuppressWarnings("unchecked")	//Map 변환 타입체크 경고 무시
		Map<String, Object> map = objectMapper.readValue(sb.toString(), Map.class);
		log.info("map: {}",map);
		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(map);
		
		//(List) 자바 객체를 json 문자열로 변환 (get)
		ObjectMapper objectMapper2 = new ObjectMapper();
			String jsonData = null;
			jsonData = objectMapper2.writeValueAsString(list);
			log.info("전송할 json 문자열: {}", jsonData);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonData);
		
	}

}
