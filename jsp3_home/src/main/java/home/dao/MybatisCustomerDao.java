package home.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import home.dto.CustomerDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {

	private SqlSessionFactory sessionFactory= SqlSessionBean.getSessionFactory();

	public int insert(CustomerDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustomer.insert", dto);
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
