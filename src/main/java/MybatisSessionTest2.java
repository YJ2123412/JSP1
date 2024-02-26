import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomer;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.CustomerBuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import project.vo.ProductVo;
public class MybatisSessionTest2 {

	public static void main(String[] args) {

		MybatisBuyDao buydao = new MybatisBuyDao();
		MybatisCustomer cusdao = new MybatisCustomer();
		MybatisProductDao prodao = new MybatisProductDao();
		
		System.out.println("dao 객체: "+buydao);
		System.out.println("dao 객체: "+cusdao);
		System.out.println("dao 객체: "+prodao);
		
		
		List<CateDto> list = prodao.getCategories();
		System.out.println(list);
	}
		
		
	public static void buydaotest() {
		System.out.println("=======buydao======="); 
		MybatisBuyDao buydao = new MybatisBuyDao();
		
		
		System.out.println("=======insert 테스트======="); 
		int result =buydao.insert(new BuyDto(0, "mina012", "CJBAb12g",7, null));
		System.out.println("반영된 행 개수: " + result);
		 
		System.out.println("=======delete 테스트=======");
		int idx = 1083;
		System.out.println(buydao.delete(idx));
		  
		System.out.println("=======update 테스트=======");
		Map<String, Integer> map = new HashMap();
		map.put("quantity", 20);
		map.put("buy_idx", 1081);      
		buydao.update(map);
			
		System.out.println("=======selectAll 테스트======="); 
		List<BuyDto> list1 =buydao.selectAll(); 
		System.out.println(list1);
		  
		System.out.println("=======searchId 테스트======="); 
		String id = "mina012";
		List<CustomerBuyDto> list2 = buydao.searchId(id); 
		System.out.println(list2);

		  
		  
	}
	public static void producttest() {
		System.out.println("=======productdao======="); 
		
		MybatisProductDao prodao = new MybatisProductDao();
	
		System.out.println("=======selectByCategory 테스트=======");
		List<ProductDto> list = prodao.selectByCategory("B1");
		System.out.println(list);
		
		System.out.println("=======selectByPname 테스트=======");
		List<ProductDto> list3 = prodao.selectByPname("진라면");
		System.out.println(list);
		
		
		
		System.out.println("=======getPriceTable 테스트=======");
		List<Map<Object, Object>> list5= prodao.getPriceTable();
		System.out.println(list5);
		 
		
		System.out.println("=======insert 테스트=======");
		prodao.insert(new ProductDto("A123", "B3", "감자", 2000));
		
		System.out.println("=======selectAll 테스트=======");
		List<ProductDto> list4 = prodao.selectAll();
		System.out.println(list4);
		
	}
	public static void customerdaotest() {
		MybatisCustomer cusdao = new MybatisCustomer();
	
		System.out.println("=======insert 테스트======="); 
		int result =cusdao.insert(new CustomerDto("id123", "일이삼","id123@naver.com", 24, null));
		System.out.println(result);
		
		
		System.out.println("=======update 테스트======="); 
		result =cusdao.update(new CustomerDto("afsd", null, "test@naver.com", 44, null));
		System.out.println(result);
		
		System.out.println("=======delete 테스트=======");
	    result = cusdao.delete("ada");
		System.out.println(result);
		
		
		System.out.println("=======getCustomer,searchId 테스트=======");
		List<CustomerBuyDto> cusbuylist =cusdao.searchId("mina012");
		System.out.println(cusbuylist);
		
		System.out.println("=======selectAll 테스트=======");
		List<CustomerDto> cuslist = cusdao.selectAll();
		System.out.println(cuslist);
	}
}
