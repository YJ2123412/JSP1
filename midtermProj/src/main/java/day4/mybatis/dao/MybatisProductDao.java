package day4.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {

	private SqlSessionFactory sessionFactory= SqlSessionBean.getSessionFactory();
	
	public List<ProductDto> search(Map<String,Object> map){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.search", map);
		sqlSession.close();
		return list;
	}
	
	
	public List<ProductDto> selectByCategory(String category) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByCategory", category);
		sqlSession.close();
		return list;
	}
	
	
	public List<ProductDto> selectByPname(String pname) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname",pname);
		sqlSession.close();
		return list;
	}
	
	
	public List<ProductDto> selectAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectAll");
		sqlSession.close();
		return list;
	}
	
	
	public int insert(ProductDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblproduct.insert", dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	
	
	  public List<Map<Object, Object>> getPriceTable() { 
		SqlSession sqlSession =sessionFactory.openSession(); 
		List<Map<Object, Object>> list= sqlSession.selectList("tblproduct.getPriceTable2");
		sqlSession.close(); 
		return list;
	  
	  }
	 
		public List<CateDto> getCategories() {
			SqlSession sqlSession = sessionFactory.openSession();
			List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
			sqlSession.close();
			return list;
		}
	  
	
	
}
