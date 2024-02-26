import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomer;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerBuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import project.vo.ProductVo;

public class MybatisSessionTest3 {

	public static void main(String[] args) {

		MybatisBuyDao buydao = new MybatisBuyDao();
		MybatisCustomer cusdao = new MybatisCustomer();
		MybatisProductDao prodao = new MybatisProductDao();

		System.out.println("=======getPriceTable 테스트=======");
		List<Map<Object, Object>> list= prodao.getPriceTable();
		System.out.println(list);
		
		System.out.println("=======selectAll 테스트=======");
		List<ProductDto> list4 = prodao.selectAll();
		System.out.println(list4);
	}
		  
}		  
		  
		  
		  
		  
		  
		  


