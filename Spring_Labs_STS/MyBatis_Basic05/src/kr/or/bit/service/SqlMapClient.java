package kr.or.bit.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "SqlMapConfig.xml";
		try {
			  Reader reader =  Resources.getResourceAsReader(resource);
			  sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
	
}
