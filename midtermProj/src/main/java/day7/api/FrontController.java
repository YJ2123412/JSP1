package day7.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/"},description = "모든 요청을 받는 서블릿")

public class FrontController extends HttpServlet {
	
	private static final long serialVersionID =1L;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	//서블릿이 톰캣에서 실행되기 시작할때 (메모리에 로드될때)실행하는 메소드
	@Override
	public void init() throws ServletException {
		RequestControllerMapping.init();
	}
	
	//get, post 상관없이 요청 처리하는 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getServletPath();
		String method = req.getMethod();
		logger.info("service 메소드: url - {}, method-{}",url, method);
		
		RequestMap map = new RequestMap(url,method);
		
		Controller controller =RequestControllerMapping.getController(map);
		logger.info("요청 key: {}",map);
		
		
			logger.info("controller 객체: {}",controller.getClass());
			controller.handle(req,resp);
		
		if(map.getUrl().equals("/products")&&map.getMethod().equals("GET")) {
			map.setUrl("/api/product");
			map.setMethod("PUT");
		}
	}
	
	//service가 처리해서 사실상 작동 X
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getServletPath();
		String method = req.getMethod();
		logger.info("doget 메소드: url - {}, method-{}",url, method);
		
		
		
	}
	
	

}

