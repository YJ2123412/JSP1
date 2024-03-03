package home;

import java.util.HashMap;
import java.util.Map;

import home.controller.Controller;
import home.controller.MemberJoinController;
import home.controller.MemberListController;
import home.controller.ProductListController;
import home.controller.ProductListController2;
import home.controller.ProductRegistController;
import home.controller.RequestMap;

public class RequestControllerMapping {

	private static final Map<RequestMap, Controller> mapping = new HashMap<>() ;
	//개발자가 만든 메소드
	public static void init() {
		mapping.put(new RequestMap("/member/memberlist","GET"),new MemberListController());
		mapping.put(new RequestMap("/member/join","GET"),new MemberJoinController());
		mapping.put(new RequestMap("/member/join","POST"),new MemberJoinController());
		mapping.put(new RequestMap("/product/productlist","GET"),new ProductListController());
		mapping.put(new RequestMap("/product/productlist2","GET"),new ProductListController2());
		mapping.put(new RequestMap("/product/regist","GET"),new ProductRegistController());
		mapping.put(new RequestMap("/product/regist","POST"),new ProductRegistController());
	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key); //value에 해당하는 controller 객체 리턴
	}
	
}
