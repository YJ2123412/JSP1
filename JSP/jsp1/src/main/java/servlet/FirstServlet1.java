
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

//서블릿이 되기 위한 몇가지(추후 정리)
//URL 필요
@WebServlet(name = "first.cc", urlPatterns = { "/first.cc" })
public class FirstServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FirstServlet1.class);

    public FirstServlet1() {
        super();
    }

    //get 요청을 처리하는 메소드 - 인자 2개 (XXXRequest, XXXResponse .. 요청과 응답에 대한 처리 가능)
    //사용자 요청을 request 객체에 저장하면서 동시에 응답을 전달할 객체 response가 생성됨
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 요청에 대한 정보출력(request 객체의 속성값): 로그 출력에서 {}는 결과값 표시     ->{} 순서대로 () 가 들어감
		logger.info("\n[MyInfo]: request URL :{} , URI: {}, 컨텍스트패스: {}",
				request.getRequestURL(),request.getRequestURI(), request.getContextPath());
		//정보: [MyInfo]: request URL :http://localhost:8088/jsp1/first.cc , URI: /jsp1/first.cc, 컨텍스트패스: /jsp1
		//url: 풀 , url:프로젝트 파일경로 , 컨텍스트패스: 프로젝트 이름
		
		//테스트: 서블릿에서 html 출력 응답도 만들어보기
		//out은 jsp는 내장객체(선언없이 사용), 서블릿은 직접 생성(response 객체로 생성)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	//responst 객체의 출력스트림 생성
		out.print("<html>");
		out.print("<head><title>WELCOME</title></head>");
		out.print("<body><h2>Hello World!!</h2>");
		out.print("현재 날짜와 시간: "+LocalDateTime.now());
		out.print("</body>");
		out.print("</html>");
		
	}
}
