package day6.mvc;

import java.util.HashMap;
import java.util.Map;

import day6.mvc.controller.CartController;
import day6.mvc.controller.CommunityListController;
import day6.mvc.controller.CommunityWriteController;
import day6.mvc.controller.Controller;
import day6.mvc.controller.LoginController;
import day6.mvc.controller.MemberJoinController;
import day6.mvc.controller.MemberModifyController;
import day6.mvc.controller.MemberSaveController;
import day6.mvc.controller.MyPageController;
import day6.mvc.controller.ProductListController;
import day6.mvc.controller.RequestMap;

//해당 클래스는 FrontController에 한번에 넣어도 됨
//requestMap key는 url과 method로 구성, value는 Controller
public class RequestControllerMapping {

	private static final Map<RequestMap, Controller> mapping = new HashMap<>() ;
	//개발자가 만든 메소드
	public static void init() {
		mapping.put(new RequestMap("/member/join","GET"),new MemberJoinController());
		mapping.put(new RequestMap("/member/save","POST"),new MemberSaveController());
		mapping.put(new RequestMap("/member/modify","GET"),new MemberModifyController());
		mapping.put(new RequestMap("/community/list","GET"),new CommunityListController());
		mapping.put(new RequestMap("/community/write","GET"),new CommunityWriteController());
		mapping.put(new RequestMap("/mypage","GET"),new MyPageController());
		mapping.put(new RequestMap("/cart","GET"),new CartController());
		mapping.put(new RequestMap("/product/list","GET"),new ProductListController());
		mapping.put(new RequestMap("/login","GET"),new LoginController());
	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key); //value에 해당하는 controller 객체 리턴
	}
	
}
