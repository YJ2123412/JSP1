package day4.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionBean;

public class MyvatisBuyDao {

	private SqlSessionFactory sessionFactory= SqlSessionBean.getSessionFactory();
	
	public MyvatisBuyDao() {
		//테스트 db연결.. 나중에는 지우기
		SqlSession sqlSession = sessionFactory.openSession();
		System.out.println("db 연결 및 sql 실행 객체: "+sqlSession);
	}
	
	
	
}
