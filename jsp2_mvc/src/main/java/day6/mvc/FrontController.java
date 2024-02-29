package day6.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import day6.mvc.controller.CommunityListController;
import day6.mvc.controller.Controller;
import day6.mvc.controller.MemberJoinController;
import day6.mvc.controller.MemberModifyController;
import day6.mvc.controller.MemberSaveController;
import day6.mvc.controller.CartController;
import day6.mvc.controller.CommunityWriteController;
import day6.mvc.controller.LoginController;
import day6.mvc.controller.MyPageController;
import day6.mvc.controller.ProductListController;
import day6.mvc.controller.RequestMap;
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
		
		//if(controller!=null) {
			logger.info("controller 객체: {}",controller.getClass());
			controller.handle(req,resp);
		
		//}
		
		/*
			 * else { resp.setContentType("text/html; charset=UTF-8"); PrintWriter out =
			 * resp.getWriter(); out.print("<script>");
			 * out.print("alert('잘못된 url 요청입니다.');");
			 * out.print("location.href='/jsp2_mvc/';"); out.print("</script>"); }
			 */
	}
	
	//service가 처리해서 사실상 작동 X
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getServletPath();
		String method = req.getMethod();
		logger.info("doget 메소드: url - {}, method-{}",url, method);
		
		
		
	}
	
	

}

/*		해당 if문은 Map을 생성하여 저장하는 방법으로 대체하겠습니다. ->requestMap key는 url과 method로 구성, value는 Controller
 * 		if(url.equals("/member/join") &&method.equals("GET")) {
			controller = new MemberJoinController();
		}else if(url.equals("/member/modify") &&method.equals("GET")) {
			controller = new MemberModifyController();
		}else if(url.equals("/member/save") &&method.equals("POST")) {
			controller = new MemberSaveController();
		}else if(url.equals("/community/list") &&method.equals("GET")) {
			controller = new CommunityListController();
		}else if(url.equals("/community/write") &&method.equals("GET")) {
			controller = new CommunityWriteController();
		}else if(url.equals("/mypage") &&method.equals("GET")) {
			controller = new MyPageController();
		}else if(url.equals("/cart") &&method.equals("GET")) {
			controller = new CartController();
		}else if(url.equals("/login") &&method.equals("GET")) {
			controller = new LoginController();
		}else if(url.equals("/product/list") &&method.equals("GET")) {
			controller = new ProductListController();
		}
 * 
 * */
