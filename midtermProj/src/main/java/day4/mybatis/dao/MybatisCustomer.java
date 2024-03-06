package day4.mybatis.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CustomerBuyDto;
import day4.mybatis.dto.CustomerDto;
import mybatis.SqlSessionBean;

public class MybatisCustomer {

	private SqlSessionFactory sessionFactory= SqlSessionBean.getSessionFactory();

	public int insert(CustomerDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustomer.insert", dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int update(CustomerDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblcustomer.update", dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<CustomerBuyDto> searchId(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerBuyDto> list = sqlSession.selectList("tblcustomer.getCustomerbuy", id);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	public CustomerDto getCustomer(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		CustomerDto dto = sqlSession.selectOne("tblcustomer.getCustomer", id);
		sqlSession.close();
		return dto;
	}
	
	public int delete(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblcustomer.delete", id);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	
	public List<CustomerDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustomer.selectAll");
		sqlSession.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
