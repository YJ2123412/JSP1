package mybatis;

import java.io.IOException;
import java.io.InputStream;
//Mybatis 프레임웍의 클래스들..
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionBean {

	public static SqlSessionFactory sqlSessionFactory;
	
	
	static {  
		String resource = "mybatis/mybatis-config.xml";   
		InputStream inputStream=null;			

		try {
			inputStream = Resources.getResourceAsStream(resource);   
		}catch(IOException e) {
			System.out.println("mybatis 설정 파일 읽기 오류입니다.");
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);   
	}

	public static SqlSessionFactory getSessionFactory() {    
		return sqlSessionFactory;
	}
}




