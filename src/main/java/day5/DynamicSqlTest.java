package day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public class DynamicSqlTest {

	public static void main(String[] args) {
		testPriceFilter();
	}
	
	
	public static void testNoFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(null);
		System.out.println("검색 필터 없음: "+list);
	}
	public static void testCateFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map= new HashMap<>();
		map.put("category","B2");//key는 파라미터 이름, value는 검색하고 싶은 컬럼 값
		List<ProductDto> list = dao.search(map);
		System.out.println("카테고리 필터: "+list);
	}
	public static void testPnameFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map= new HashMap<>();
		map.put("keyword","사과");	
		List<ProductDto> list = dao.search(map);
		System.out.println("이름 필터: "+list);
	}
	
	public static void testPnameCateFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map= new HashMap<>();
		map.put("category","B2");
		map.put("keyword","사과");	
		List<ProductDto> list = dao.search(map);
		System.out.println("이름+category 필터: "+list);
	}
	
	public static void testPriceFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map= new HashMap<>();
		map.put("from", 10000);
		map.put("to", 80000);	
		map.put("column","price");
		List<ProductDto> list = dao.search(map);
		System.out.println("가격 필터: "+list);
	}
	
	public static void testAllFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map= new HashMap<>();
		map.put("category","B2");
		map.put("keyword","사과");	
		map.put("from", 10000);
		map.put("to", 40000);
		
		List<ProductDto> list = dao.search(map);
		System.out.println("이름+category+가격 필터: "+list);
	}
	
	
	
}
