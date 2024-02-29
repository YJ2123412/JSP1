package home.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestControllerMapping {

	private static final Map<RequestMap, Controller> mapping = new HashMap<>() ;
	//개발자가 만든 메소드
	public static void init() {
		mapping.put(new RequestMap("/member/list","GET"),new MemberListController());
		mapping.put(new RequestMap("/member/join","GET"),new MemberJoinGETController());
		mapping.put(new RequestMap("/member/join","POST"),new MemberJoinPostController());
		mapping.put(new RequestMap("/product/list","GET"),new ProductRegistGetController());
		mapping.put(new RequestMap("/product/regist","GET"),new ProductRegistGetController());
		mapping.put(new RequestMap("/product/regist","POST"),new ProductRegistPostController());
	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key); //value에 해당하는 controller 객체 리턴
	}
	
}
