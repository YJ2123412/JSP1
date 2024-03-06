package day7.api;

import java.util.HashMap;
import java.util.Map;


public class RequestControllerMapping {

	private static final Map<RequestMap, Controller> mapping = new HashMap<>() ;
	//rest api 컨트롤러는 /api로 시작하도록 함
	public static void init() {
		//기존 통신 컨트롤러  - 화면 보여주기
		mapping.put(new RequestMap("/member/list","GET"),new MemberListController());
		mapping.put(new RequestMap("/member/join","GET"),new MemberJoinController());
		mapping.put(new RequestMap("/member/join","POST"),new MemberJoinController());
		
		
		
		mapping.put(new RequestMap("/products","GET"), new ProductsController());
		mapping.put(new RequestMap("/products","PUT"), new ApiProductSearchController());
		mapping.put(new RequestMap("/buys","GET"), new BuysController());
		
		
		//비동기 통신을 위한 api 제공 컨트롤러
		mapping.put(new RequestMap("/api/product/list","GET"),new ApiProductListController());
		mapping.put(new RequestMap("/api/product","POST"),new ApiProductPostController());
		mapping.put(new RequestMap("/api/buy/list","GET"),new ApiBuyListController());
		
		//상품 검색
		mapping.put(new RequestMap("/api/product","PUT"),new ApiProductSearchController());
	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key); //value에 해당하는 controller 객체 리턴
	}
	
}
