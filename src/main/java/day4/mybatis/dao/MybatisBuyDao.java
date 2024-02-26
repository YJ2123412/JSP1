package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerBuyDto;
import day4.mybatis.dto.CustomerDto;
import mybatis.SqlSessionBean;

public class MybatisBuyDao {

	private SqlSessionFactory sessionFactory= SqlSessionBean.getSessionFactory();
	
	
	public MybatisBuyDao() {
		//테스트 db연결.. 나중에는 지우기
		//SqlSession sqlSession = sessionFactory.openSession();
		//System.out.println("db 연결 및 sql 실행 객체: "+sqlSession);
	}
	
	//SqlSession 객체 select, insert, update, delete 메소드는 SQL을 실행
	//	ㄴ첫번째 인자는 sql 매퍼 파일은 namespace 속성.id속성
	//	ㄴ두번째 인자는 sql 실행에 파라미터가 있을 시 작성(없으면 생략)
	
	public List<BuyDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<BuyDto> list = sqlSession.selectList("tblbuy.selectAll");
		sqlSession.close();
		return list;
	}
	
	
	//마이바티스는 auto commit X
	public int insert(BuyDto dto) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblbuy.insert", dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int update(Map<String, Integer> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblbuy.update", map);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int delete(int buyidx) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblbuy.delete", buyidx);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<CustomerBuyDto> searchId(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerBuyDto> list = sqlSession.selectList("tblbuy.searchId", id);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	
	
	
	
	
	
}
